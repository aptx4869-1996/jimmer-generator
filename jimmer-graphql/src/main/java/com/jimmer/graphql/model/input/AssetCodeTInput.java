package com.jimmer.graphql.model.input;

import lombok.Data;
import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;
import java.util.Date;
/*
* 标准代码资产表
*/
@Data
public class AssetCodeTInput {
    private String tid;
    private String assetId;
    private String codeType;
    private String codeStatus;
    private String isRemove;
    private Date metaCreateTime;
    private Date metaUpdateTime;
    private String tenantId;
    private String revision;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String isDel;

}