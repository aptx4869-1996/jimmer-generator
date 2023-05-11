package cn.lemon.generator.analyse;

import cn.lemon.generator.Constant;
import cn.lemon.generator.convert.DataTypeConvert;
import cn.lemon.generator.convert.MysqlConvert;
import cn.lemon.generator.model.ColumnInfo;
import cn.lemon.generator.model.TableInfo;
import cn.lemon.generator.runner.Runner;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;

@Component
@ConditionalOnProperty(value = "jimmer.generator.database-type", havingValue = Constant.DATA_TYPE_MYSQL)
public class MysqlAnalyse implements DataBaseAnalyse {
    private final Logger logger = LoggerFactory.getLogger(MysqlAnalyse.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataTypeConvert dataType2JavaType;

    @Value("${jimmer.generator.target-table}")
    private List<String> targetTableNames;

    @Override
    public List<TableInfo> obtainTableInfos() {
        logger.info("table-info obtaining........... start");
        StringBuilder sqlBuilder = new StringBuilder(" select * from information_schema.tables ");
        sqlBuilder.append(" where table_schema = (select database()) ");
        List<TableInfo> tableInfos = jdbcTemplate.query(sqlBuilder.toString()
                , (ResultSet rs, int rowNum) -> {
                    //转换查询结果集为表信息
                    TableInfo tableInfo = new TableInfo();
                    String tableName = rs.getString("TABLE_NAME");
                    boolean flag = (targetTableNames != null && targetTableNames.contains(tableName))
                            || ObjectUtils.isEmpty(targetTableNames);
                    if (!flag) return tableInfo;

                    logger.info("table-info obtaining...........【{}】", tableName);
                    tableInfo.setTableName(tableName);
                    tableInfo.setTableComment(rs.getString("TABLE_COMMENT"));
                    if (ObjectUtils.isEmpty(tableName)) return tableInfo;
                    StringBuilder className = new StringBuilder();
                    String[] tmp = tableName.trim().replaceAll(" ", "").split("_");
                    for (int i = 0; i < tmp.length; i++) {
                        className.append(tmp[i].substring(0, 1).toUpperCase());
                        className.append(tmp[i].substring(1).toLowerCase());
                    }
                    tableInfo.setClassName(className.toString());

                    return tableInfo;
                }
        );
        logger.info("table-info obtaining........... end");
        return tableInfos;
    }

    @Override
    public List<ColumnInfo> obtainColumnInfos(String tableName) {
        StringBuilder sqlBuilder = new StringBuilder(" SELECT * FROM INFORMATION_SCHEMA.COLUMNS ");
        sqlBuilder.append(" WHERE table_name = '").append(tableName).append("' ");
        sqlBuilder.append(" AND table_schema = (select database()) ");
        List<ColumnInfo> columnInfos = jdbcTemplate.query(sqlBuilder.toString(), (ResultSet rs, int rowNum) -> {
            //列基本信息
            ColumnInfo columnInfo = new ColumnInfo();
            String columnName = rs.getString("COLUMN_NAME");
            String fieldType = rs.getString("DATA_TYPE");
            columnInfo.setColumnName(columnName);
            columnInfo.setColumnType(fieldType);
            columnInfo.setNullable(rs.getString("IS_NULLABLE"));
            columnInfo.setKey(rs.getString("COLUMN_KEY"));
            //驼峰转换
            if (ObjectUtils.isNotEmpty(columnName)) {
                logger.info("column-info obtaining...........【{}】：{}", tableName, columnName);
                StringBuilder fieldName = new StringBuilder();
                String[] tmp = columnName.trim().replaceAll(" ", "").split("_");
                for (int i = 0; i < tmp.length; i++) {
                    if (i > 0) {
                        fieldName.append(tmp[i].substring(0, 1).toUpperCase());
                        fieldName.append(tmp[i].substring(1).toLowerCase());
                    } else {
                        fieldName.append(tmp[i].toLowerCase());
                    }
                }
                columnInfo.setFieldName(fieldName.toString());
            }
            //数据库类型和java类型转换
            columnInfo.setColumnType(dataType2JavaType.dataType2JavaType(fieldType));
            return columnInfo;
        });
        return columnInfos;
    }
}
