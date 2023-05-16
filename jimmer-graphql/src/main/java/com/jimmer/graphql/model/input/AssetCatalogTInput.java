package com.jimmer.graphql.model.input;

import lombok.Data;
import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;
import java.util.Date;
/*
* 资源目录表
*/
@Data
public class AssetCatalogTInput {
    private String tid;
    private String assetId;
    private String shareCondCode;
    private String tenantId;
    private String revision;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String isDel;

}