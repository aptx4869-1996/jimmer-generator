package com.jimmer.graphql.cfg;

import graphql.schema.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.Date;


@Configuration
public class GraphQLConfig {

    private static final GraphQLScalarType GRAPHQL_LOCAL_DATE_TIME =
            GraphQLScalarType.newScalar()
                    .name("Date").description("java.util.Date")
                    .coercing(
                            new Coercing<Date, Date>() {
                                @Override
                                public Date serialize(@NotNull Object dataFetcherResult) throws CoercingSerializeException {
                                    return (Date) dataFetcherResult;
                                }

                                @Override
                                public @NotNull Date parseValue(@NotNull Object input) throws CoercingParseValueException {
                                    throw new UnsupportedOperationException();
                                }

                                @Override
                                public @NotNull Date parseLiteral(@NotNull Object input) throws CoercingParseLiteralException {
                                    throw new UnsupportedOperationException();
                                }
                            }
                    )
                    .build();

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> {
            wiringBuilder
//                    .scalar(ExtendedScalars.GraphQLLong)
//                    .scalar(ExtendedScalars.GraphQLBigDecimal)
                    .scalar(GRAPHQL_LOCAL_DATE_TIME);
        };
    }
}
