package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetTableT;
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
 * 表资产
 */
@Data
public class AssetTableTInput implements Input<AssetTableT> {

    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

    private String tid;
    private String assetId;
    private String columnTotal;
    private String rowTotal;
    private String dataSize;
    private LocalDateTime ddlCreateTime;
    private LocalDateTime ddlUpdateTime;
    private LocalDateTime dataUpdateTime;
    private String tenantId;
    private String revision;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private String isDel;

    @Override
    public AssetTableT toEntity() {
        return CONVERTER.toAssetTableT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetTableT toAssetTableT(AssetTableTInput input);
    }

}