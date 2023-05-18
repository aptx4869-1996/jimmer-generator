package com.jimmer.graphql.controller;

import com.jimmer.graphql.model.entity.AssetDataT;
import com.jimmer.graphql.model.input.AssetDataTInput;
import com.jimmer.graphql.repository.AssetApplicationTRepository;
import com.jimmer.graphql.repository.AssetDataTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Controller
public class AssetController {

    @Autowired
    private AssetDataTRepository assetDataTRepository;

    @Autowired
    private AssetApplicationTRepository assetApplicationTRepository;

    @QueryMapping
    public List<AssetDataT> assetDataT(@Argument AssetDataTInput assetDataT) {
        return assetDataTRepository.findByCondition(assetDataT);
    }


    @MutationMapping
    @Transactional(rollbackFor = Exception.class)
    public AssetDataT saveAssetData(@Argument AssetDataTInput input) {
        return assetDataTRepository.save(input);
    }

    @MutationMapping
    @Transactional(rollbackFor = Exception.class)
    public void deleteAssetData(@Argument List<String> ids) {
        assetDataTRepository.deleteByIds(ids);
    }
}
