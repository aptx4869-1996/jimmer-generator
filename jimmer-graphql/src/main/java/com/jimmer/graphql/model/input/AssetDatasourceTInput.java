package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetDatasourceT;
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
 * 数据源资产
 */
@Data
public class AssetDatasourceTInput implements Input<AssetDatasourceT> {

    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

    private String tid;
    private String assetId;
    private String dbType;
    private String dbIp;
    private String dbPort;
    private String dbUser;
    private String dbPassword;
    private String dbMetaType;
    private String dbMetaIp;
    private String dbMetaPort;
    private String dbMetaUser;
    private String dbMetaPassword;
    private String dbVersion;
    private String tableTotal;
    private String viewTotal;
    private String prcTotal;
    private String fucTotal;
    private String userTotal;
    private String dataTotal;
    private String dataSize;
    private String tenantId;
    private String revision;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private String isDel;

    @Override
    public AssetDatasourceT toEntity() {
        return CONVERTER.toAssetDatasourceT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetDatasourceT toAssetDatasourceT(AssetDatasourceTInput input);
    }

}