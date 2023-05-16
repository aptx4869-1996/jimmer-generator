package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;

/*
 * 应用资产表
 */
@Entity
@Table(name = "asset_application_t")
public interface AssetApplicationT {
    @Column(name = "tid")
    @Id
    String tid();

//    @Column(name = "asset_id")
//    String assetId();

    @Column(name = "pro_id")
    @Nullable
    String proId();

    @Column(name = "app_type")
    @Nullable
    String appType();

    @Column(name = "app_url")
    @Nullable
    String appUrl();

    @Column(name = "sys_archi_type")
    @Nullable
    String sysArchiType();

    @Column(name = "auth_level")
    @Nullable
    String authLevel();

    @Column(name = "online_time")
    @Nullable
    Date onlineTime();

    @Column(name = "offline_time")
    @Nullable
    Date offlineTime();

    @Column(name = "icon")
    @Nullable
    String icon();

    @Column(name = "icon_url")
    @Nullable
    String iconUrl();

    @Column(name = "net_type")
    @Nullable
    String netType();

    @Column(name = "sys_deploy")
    @Nullable
    String sysDeploy();

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


    @ManyToOne
    @Nullable
    AssetDataT asset();

}