package com.jimmer.graphql.model.input;

import lombok.Data;
import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;
import java.util.Date;
/*
* 数据源资产
*/
@Data
public class AssetDatasourceTInput {
    private String tid;
    private String assetId;
    private String dbType;
    private String dbIp;
    private String dbPort;
    private String dbUser;
    private String dbPassword;
    private String dbMetaType;
    private String dbMetaIp;
    private String dbMetaPort;
    private String dbMetaUser;
    private String dbMetaPassword;
    private String dbVersion;
    private String tableTotal;
    private String viewTotal;
    private String prcTotal;
    private String fucTotal;
    private String userTotal;
    private String dataTotal;
    private String dataSize;
    private String tenantId;
    private String revision;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String isDel;

}