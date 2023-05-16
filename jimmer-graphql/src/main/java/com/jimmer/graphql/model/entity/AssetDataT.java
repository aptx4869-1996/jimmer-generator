package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

/*
 * 资产主表
 */
@Entity
@Table(name = "asset_data_t")
public interface AssetDataT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_name")
    String assetName();

    @Column(name = "resource_name")
    @Nullable
    String resourceName();

    @Column(name = "asset_class")
    @Nullable
    String assetClass();

    @Column(name = "asset_desc")
    @Nullable
    String assetDesc();

    @Column(name = "asset_identifier")
    @Nullable
    String assetIdentifier();

    @Column(name = "asset_code")
    @Nullable
    String assetCode();

    @Column(name = "id_mapping")
    @Nullable
    String idMapping();

    @Column(name = "asset_version")
    @Nullable
    String assetVersion();

    @Column(name = "asset_status")
    @Nullable
    String assetStatus();

    @Column(name = "is_activity")
    @Nullable
    String isActivity();

    @Column(name = "channel_code")
    @Nullable
    String channelCode();

    @Column(name = "dynamic_metadata")
    @Nullable
    String dynamicMetadata();

    @Column(name = "register_time")
    @Nullable
    Date registerTime();

    @Column(name = "publish_time")
    @Nullable
    Date publishTime();

    @Column(name = "off_shelf_time")
    @Nullable
    Date offShelfTime();

    @Column(name = "archiving_time")
    @Nullable
    Date archivingTime();

    @Column(name = "pass_time")
    @Nullable
    Date passTime();

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


    @OneToMany(mappedBy = "asset")
    List<AssetApplicationT> assetApplications();
}