package com.jimmer.generator.model;

import lombok.Data;

import java.util.List;

@Data
public class TableInfo {

    private String tableName;

    private String tableComment;

    private String className;

    private List<ColumnInfo> columnInfos;

}
