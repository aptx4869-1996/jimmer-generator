package com.jimmer.graphql.repository;

import com.jimmer.graphql.model.entity.*;
import com.jimmer.graphql.model.input.AssetApplicationTInput;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.List;

public interface AssetApplicationTRepository extends JRepository<AssetApplicationT, String> {

    AssetApplicationTTable table = AssetApplicationTTable.$;
    AssetApplicationTFetcher fetcher = AssetApplicationTFetcher.$;
    

//    default List<AssetApplicationTInput> findByCondition(AssetApplicationTInput input){
//        return sql()
//                .createQuery(table)
//                .where(table.eq(input))
//                .select(table)
//                .execute();
//    };
}