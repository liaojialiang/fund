package xyz.liaojl.fund.config;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.time.LocalDateTime;

public class JpaLocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {
    @Override
    public String convertToDatabaseColumn(LocalDateTime attribute) {
        if (attribute == null)
            return null;
        return attribute.toString();
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return null;
        return LocalDateTime.parse(dbData);
    }
}
