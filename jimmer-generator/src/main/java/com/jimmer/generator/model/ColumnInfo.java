package com.jimmer.generator.model;

import lombok.Data;

@Data
public class ColumnInfo {
    private String columnName;

    private String columnType;

    private String nullable;

    private String key;

    private String fieldName;
}
