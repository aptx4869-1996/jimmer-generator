package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetCodeT;
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
 * 标准代码资产表
 */
@Data
public class AssetCodeTInput implements Input<AssetCodeT> {

    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

    private String tid;
    private String assetId;
    private String codeType;
    private String codeStatus;
    private String isRemove;
    private LocalDateTime metaCreateTime;
    private LocalDateTime metaUpdateTime;
    private String tenantId;
    private String revision;
    private String createdBy;
    private LocalDateTime createdTime;
    private String updatedBy;
    private LocalDateTime updatedTime;
    private String isDel;

    @Override
    public AssetCodeT toEntity() {
        return CONVERTER.toAssetCodeT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetCodeT toAssetCodeT(AssetCodeTInput input);
    }

}