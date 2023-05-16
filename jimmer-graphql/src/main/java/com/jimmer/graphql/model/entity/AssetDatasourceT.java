package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;
/*
 * 数据源资产
 */
@Entity
@Table(name = "asset_datasource_t")
public interface AssetDatasourceT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_id")
    @Nullable
    String assetId();

    @Column(name = "db_type")
    @Nullable
    String dbType();

    @Column(name = "db_ip")
    @Nullable
    String dbIp();

    @Column(name = "db_port")
    @Nullable
    String dbPort();

    @Column(name = "db_user")
    @Nullable
    String dbUser();

    @Column(name = "db_password")
    @Nullable
    String dbPassword();

    @Column(name = "db_meta_type")
    @Nullable
    String dbMetaType();

    @Column(name = "db_meta_ip")
    @Nullable
    String dbMetaIp();

    @Column(name = "db_meta_port")
    @Nullable
    String dbMetaPort();

    @Column(name = "db_meta_user")
    @Nullable
    String dbMetaUser();

    @Column(name = "db_meta_password")
    @Nullable
    String dbMetaPassword();

    @Column(name = "db_version")
    @Nullable
    String dbVersion();

    @Column(name = "table_total")
    @Nullable
    String tableTotal();

    @Column(name = "view_total")
    @Nullable
    String viewTotal();

    @Column(name = "prc_total")
    @Nullable
    String prcTotal();

    @Column(name = "fuc_total")
    @Nullable
    String fucTotal();

    @Column(name = "user_total")
    @Nullable
    String userTotal();

    @Column(name = "data_total")
    @Nullable
    String dataTotal();

    @Column(name = "data_size")
    @Nullable
    String dataSize();

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