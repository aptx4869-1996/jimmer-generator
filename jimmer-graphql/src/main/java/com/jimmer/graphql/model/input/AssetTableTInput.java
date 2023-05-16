package com.jimmer.graphql.model.input;

import lombok.Data;
import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;
import java.util.Date;
/*
* 表资产
*/
@Data
public class AssetTableTInput {
    private String tid;
    private String assetId;
    private String columnTotal;
    private String rowTotal;
    private String dataSize;
    private Date ddlCreateTime;
    private Date ddlUpdateTime;
    private Date dataUpdateTime;
    private String tenantId;
    private String revision;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String isDel;

}