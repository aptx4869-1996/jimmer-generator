package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;

/*
 * 表资产
 */
@Entity
@Table(name = "asset_table_t")
public interface AssetTableT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_id")
    @Nullable
    String assetId();

    @Column(name = "column_total")
    @Nullable
    String columnTotal();

    @Column(name = "row_total")
    @Nullable
    String rowTotal();

    @Column(name = "data_size")
    @Nullable
    String dataSize();

    @Column(name = "ddl_create_time")
    @Nullable
    Date ddlCreateTime();

    @Column(name = "ddl_update_time")
    @Nullable
    Date ddlUpdateTime();

    @Column(name = "data_update_time")
    @Nullable
    Date dataUpdateTime();

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