package com.jimmer.generator.convert;

import com.jimmer.generator.Constant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "jimmer.generator.database-type", havingValue = Constant.DATA_TYPE_MYSQL)
public class MysqlConvert implements DataTypeConvert {
    @Override
    public String dataType2JavaType(String fieldType) {
        String colType = null;
        switch (fieldType) {
            case "datetime" -> colType = "LocalDateTime";
            default -> colType = "String";
        }
        return colType;
    }
}
