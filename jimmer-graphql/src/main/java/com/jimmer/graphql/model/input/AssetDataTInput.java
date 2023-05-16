package com.jimmer.graphql.model.input;

import com.jimmer.graphql.model.entity.AssetDataT;
import org.babyfish.jimmer.Input;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


public class AssetDataTInput implements Input<AssetDataT> {
    private static final Converter CONVERTER = Mappers.getMapper(Converter.class);

    private String tid;

    private String assetName;

    private String resourceName;

    private List<AssetApplicationTInput> assetApplications;

    @Override
    public AssetDataT toEntity() {
        return CONVERTER.toAssetDataT(this);
    }

    @Mapper
    interface Converter {
        @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
        AssetDataT toAssetDataT(AssetDataTInput input);
    }


    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public List<AssetApplicationTInput> getAssetApplications() {
        return assetApplications;
    }

    public void setAssetApplications(List<AssetApplicationTInput> assetApplications) {
        this.assetApplications = assetApplications;
    }
}
