package hac;

import hac.entity.Condition;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;
@Converter
public class ConditionsConverter implements AttributeConverter<Set<Condition>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Condition> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        return attribute.stream().map(Condition::name).reduce((a, b) -> a + "," + b).orElse("");
    }

    @Override
    public Set<Condition> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().length() == 0) {
            return EnumSet.noneOf(Condition.class);
        }
        Set<Condition> conditions = EnumSet.noneOf(Condition.class);
        Arrays.stream(dbData.split(",")).forEach(condition -> conditions.add(Condition.valueOf(condition)));
        return conditions;
    }
}