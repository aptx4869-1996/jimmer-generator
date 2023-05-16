package com.jimmer.graphql.controller;

import com.jimmer.graphql.model.entity.AssetDataT;
import com.jimmer.graphql.repository.AssetDataTRepository;
import com.jimmer.graphql.model.input.AssetDataTInput;
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

    @QueryMapping
    public List<AssetDataT> assetDataT(@Argument AssetDataTInput input) {
        return assetDataTRepository.findByAssetName(input.toEntity().assetName());
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
