package com.jimmer.generator.analyse;

import com.jimmer.generator.model.ColumnInfo;
import com.jimmer.generator.model.TableInfo;

import java.util.List;

public interface DataBaseAnalyse {

    List<TableInfo> obtainTableInfos();

    List<ColumnInfo> obtainColumnInfos(String tableName);
}
