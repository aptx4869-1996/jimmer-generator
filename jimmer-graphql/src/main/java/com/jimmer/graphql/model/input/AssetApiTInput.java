package com.jimmer.graphql.model.input;

import lombok.Data;

import java.util.Date;
/*
* 服务资产
*/
@Data
public class AssetApiTInput {
    private String tid;
    private String assetId;
    private String serviceVersion;
    private String serviceType;
    private String respContentType;
    private String reqProtocol;
    private String reqMethod;
    private String reqUrl;
    private String gatewayServiceId;
    private String groupId;
    private String groupName;
    private String isAuthorizes;
    private String reqTotalTimes;
    private String reqSuccessTimes;
    private String appNum;
    private String avgTimming;
    private String score;
    private String tenantId;
    private String revision;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
    private String isDel;
    
    
}