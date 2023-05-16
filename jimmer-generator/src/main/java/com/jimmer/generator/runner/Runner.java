package com.jimmer.generator.runner;

import com.jimmer.generator.analyse.DataBaseAnalyse;
import com.jimmer.generator.model.ColumnInfo;
import com.jimmer.generator.model.TableInfo;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class Runner {

    private final Logger logger = LoggerFactory.getLogger(Runner.class);
    @Autowired
    private DataBaseAnalyse dataBaseAnalyse;

    @Value("${jimmer.generator.package-name-prefix}")
    private String packageName;

    @Value("${jimmer.generator.output}")
    private String output;

    public void process() throws Exception {
        logger.info("process start............");
        List<TableInfo> tableInfos = dataBaseAnalyse.obtainTableInfos();
        Assert.notEmpty(tableInfos, "tableInfos is Empty");
        tableInfos.stream()
                .filter(tableInfo -> !ObjectUtils.isEmpty(tableInfo.getTableName()))
                .forEach(tableInfo -> {
                    //获取表中字段信息
                    List<ColumnInfo> columnInfos = dataBaseAnalyse.obtainColumnInfos(tableInfo.getTableName());
                    tableInfo.setColumnInfos(columnInfos);
                    //填写模板写出
                    VelocityContext context = new VelocityContext();
                    columnInfos.stream().forEach(columnInfo -> {
                        context.put("tableInfo", tableInfo);
                        context.put("list", columnInfos);
                        context.put("packageName", packageName);
                    });
                    try {
                        //entity模板写出
                        String entityDirPath = output + File.separator + "model" + File.separator + "entity";
                        writeOutTmp(entityDirPath
                                , tableInfo.getClassName() + ".java"
                                , "jimmer-generator/src/main/resources/Entity.vm"
                                , context);
                        //input模板写出
                        String inputDirPath = output + File.separator + "model" + File.separator + "input";
                        writeOutTmp(inputDirPath
                                , tableInfo.getClassName() + "Input.java"
                                , "jimmer-generator/src/main/resources/Input.vm"
                                , context);
                        //jpa接口模板写出
                        String jpaDirPath = output + File.separator + "repository";
                        writeOutTmp(jpaDirPath
                                , tableInfo.getClassName() + "Repository.java"
                                , "jimmer-generator/src/main/resources/Repository.vm"
                                , context);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        //写出graphQL
        VelocityContext context = new VelocityContext();
        context.put("tableInfos", tableInfos);
        String graphQLDirPath = output + File.separator + "resource" + File.separator + "graphql";
        writeOutTmp(graphQLDirPath,
                "schema.graphqls",
                "jimmer-generator/src/main/resources/graphqls.vm",
                context);
        logger.info("process end............");
    }


    private void writeOutTmp(String path, String fileName, String tempPath, VelocityContext context) throws Exception {
        File jpaDir = new File(path);
        if (!jpaDir.exists()) jpaDir.mkdirs();
        File jpaFile = new File(path + File.separator + fileName);
        FileWriter jpaFileWr = new FileWriter(jpaFile);
        new VelocityEngine().mergeTemplate(tempPath, "UTF-8", context, jpaFileWr);
        jpaFileWr.flush();
    }

}
