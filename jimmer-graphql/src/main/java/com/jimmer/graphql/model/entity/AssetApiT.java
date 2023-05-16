package com.jimmer.graphql.model.entity;

import org.babyfish.jimmer.sql.*;
import org.springframework.lang.Nullable;

import java.util.Date;

/*
 * 服务资产
 */
@Entity
@Table(name = "asset_api_t")
public interface AssetApiT {
    @Column(name = "tid")
    @Id
    String tid();

    @Column(name = "asset_id")
    @Nullable
    String assetId();

    @Column(name = "service_version")
    @Nullable
    String serviceVersion();

    @Column(name = "service_type")
    @Nullable
    String serviceType();

    @Column(name = "resp_content_type")
    @Nullable
    String respContentType();

    @Column(name = "req_protocol")
    @Nullable
    String reqProtocol();

    @Column(name = "req_method")
    @Nullable
    String reqMethod();

    @Column(name = "req_url")
    String reqUrl();

    @Column(name = "gateway_service_id")
    @Nullable
    String gatewayServiceId();

    @Column(name = "group_id")
    @Nullable
    String groupId();

    @Column(name = "group_name")
    @Nullable
    String groupName();

    @Column(name = "is_authorizes")
    @Nullable
    String isAuthorizes();

    @Column(name = "req_total_times")
    @Nullable
    String reqTotalTimes();

    @Column(name = "req_ success_times")
    @Nullable
    String reqSuccessTimes();

    @Column(name = "app_num")
    @Nullable
    String appNum();

    @Column(name = "avg_timming")
    @Nullable
    String avgTimming();

    @Column(name = "score")
    @Nullable
    String score();

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