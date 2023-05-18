package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetCatalogT;
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
 * 资源目录表
 */
@Data
public class AssetCatalogTInput implements Input<AssetCatalogT> {

    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

    private String tid;
    private String assetId;
    private String shareCondCode;
    private String tenantId;
    private String revision;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private String isDel;

    @Override
    public AssetCatalogT toEntity() {
        return CONVERTER.toAssetCatalogT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetCatalogT toAssetCatalogT(AssetCatalogTInput input);
    }

}