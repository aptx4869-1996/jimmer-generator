package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetApiT;
import lombok.Data;
import org.babyfish.jimmer.Input;
import org.babyfish.jimmer.sql.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/*
 * 服务资产
 */
@Data
public class AssetApiTInput implements Input<AssetApiT> {

    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

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
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private String isDel;

    @Override
    public AssetApiT toEntity() {
        return CONVERTER.toAssetApiT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetApiT toAssetApiT(AssetApiTInput input);
    }

}