package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;
/*
 * 资源目录表
 */
@Entity
@Table(name = "asset_catalog_t")
public interface AssetCatalogT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_id")
    @Nullable
    String assetId();

    @Column(name = "share_cond_code")
    @Nullable
    String shareCondCode();

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