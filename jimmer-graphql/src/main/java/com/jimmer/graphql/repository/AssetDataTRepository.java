package com.jimmer.graphql.repository;


import com.jimmer.graphql.model.entity.AssetDataT;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.List;

public interface AssetDataTRepository extends JRepository<AssetDataT, String> {



    List<AssetDataT> findByAssetName(String assetName);


//    default Page<AssetDataT> pageAssetDataT(Pageable pageable, DataAssetRegistrationVo params) {
//        AssetDataTTable assetDataTTable = AssetDataTTable.$;
//        return pager(pageable)
//                .execute(
//                        sql().createQuery(assetDataTTable)
//                                .select(
//                                        assetDataTTable.fetch(AssetDataTFetcher.$.allScalarFields())
//                                )
//                );
//    }

    ;


}