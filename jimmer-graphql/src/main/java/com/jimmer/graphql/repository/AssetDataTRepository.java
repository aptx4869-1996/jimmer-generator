package com.jimmer.graphql.repository;


import cn.hutool.core.util.ObjectUtil;
import com.jimmer.graphql.model.entity.AssetDataT;
import com.jimmer.graphql.model.entity.AssetDataTFetcher;
import com.jimmer.graphql.model.entity.AssetDataTTable;
import com.jimmer.graphql.model.input.AssetDataTInput;
import org.babyfish.jimmer.spring.repository.JRepository;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.ast.PropExpression;
import org.babyfish.jimmer.sql.ast.query.MutableRootQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;
import java.util.List;

public interface AssetDataTRepository extends JRepository<AssetDataT, String> {
    AssetDataTTable table = AssetDataTTable.$;
    AssetDataTFetcher fetcher = AssetDataTFetcher.$;

    List<AssetDataT> findByAssetName(String assetName);


    default List<AssetDataT> findByCondition(AssetDataTInput input) {
        return sql()
                .createQuery(table)
                .where(table.eq(input))
                .select(table)
                .execute();
//        return sql()
//                .getEntities()
//                .findByIds(AssetDataTFetcher.$.allScalarFields()
//                        , new ArrayList(Arrays.asList(input.getTid())));
    }

    default MutableRootQuery createInner(MutableRootQuery mutableRootQuery, Object input) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(input);
        Arrays.stream(beanWrapper.getPropertyDescriptors()).forEach(pd -> {
            if (pd.getPropertyType().isAnnotationPresent(Entity.class)) {
                //是类则向下递归拼接该类型where条件
                createInner(mutableRootQuery, beanWrapper.getPropertyValue(pd.getName()));
            } else {
                //普通参数进行where拼接
                try {
                    PropExpression propExpression = (PropExpression) pd.getValue(pd.getName());
                    Object value = pd.getReadMethod().invoke(input);
                    mutableRootQuery.whereIf(ObjectUtil.isNotEmpty(value), propExpression.eq(value));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return mutableRootQuery;
    }


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