package cn.lemon.generator.analyse;

import cn.lemon.generator.model.ColumnInfo;
import cn.lemon.generator.model.TableInfo;

import java.util.List;

public interface DataBaseAnalyse {

    List<TableInfo> obtainTableInfos();

    List<ColumnInfo> obtainColumnInfos(String tableName);
}
