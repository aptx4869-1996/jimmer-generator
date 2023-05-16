package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;
/*
 * 标准代码资产表
 */
@Entity
@Table(name = "asset_code_t")
public interface AssetCodeT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_id")
    @Nullable
    String assetId();

    @Column(name = "code_type")
    @Nullable
    String codeType();

    @Column(name = "code_status")
    @Nullable
    String codeStatus();

    @Column(name = "is_remove")
    @Nullable
    String isRemove();

    @Column(name = "meta_create_time")
    @Nullable
    Date metaCreateTime();

    @Column(name = "meta_update_time")
    @Nullable
    Date metaUpdateTime();

    @Column(name = "tenant_id")
    @Nullable
    String tenantId();

    @Column(name = "revision")
    @Nullable
    String revision();

    @Column(name = "created_by")
    @Nullable
    String createdBy();

    @Column(name = "created_time")
    @Nullable
    Date createdTime();

    @Column(name = "updated_by")
    @Nullable
    String updatedBy();

    @Column(name = "updated_time")
    @Nullable
    Date updatedTime();

    @Column(name = "is_del")
    @LogicalDeleted(value = "1", restoredValue = "0")
    int isDel();

}