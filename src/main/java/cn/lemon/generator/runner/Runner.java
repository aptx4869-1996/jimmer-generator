package cn.lemon.generator.runner;

import cn.lemon.generator.analyse.DataBaseAnalyse;
import cn.lemon.generator.model.ColumnInfo;
import cn.lemon.generator.model.TableInfo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Arrays;
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
        tableInfos.stream().forEach(tableInfo -> {
            //获取表中字段信息
            List<ColumnInfo> columnInfos = dataBaseAnalyse.obtainColumnInfos(tableInfo.getTableName());
            //填写模板写出
            VelocityContext context = new VelocityContext();
            columnInfos.stream().forEach(columnInfo -> {
                context.put("tableInfo", tableInfo);
                context.put("list", columnInfos);
                context.put("packageName", packageName);
            });
            try {
                //entity模板写出
                File file = new File(output
                        + File.separator + "model"
                        + File.separator + "entity"
                        + File.separator + tableInfo.getClassName() + ".java");
                FileWriter fileWriter = new FileWriter(file);
                VelocityEngine velocityEngine = new VelocityEngine();
                velocityEngine.mergeTemplate("src/main/resources/Entity.vm", "UTF-8", context, fileWriter);
                fileWriter.flush();
                //jpa接口模板写出
                File file2 = new File(output
                        + File.separator + "repository"
                        + File.separator + tableInfo.getClassName() + "Repository.java");
                FileWriter fileWriter2 = new FileWriter(file2);
                VelocityEngine velocityEngine2 = new VelocityEngine();
                velocityEngine2.mergeTemplate("src/main/resources/Repository.vm", "UTF-8", context, fileWriter2);
                fileWriter2.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        logger.info("process end............");
    }

}
