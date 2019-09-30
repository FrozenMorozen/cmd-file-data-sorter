package com.company.param.type;

import java.util.List;

public enum DataType {
    INTEGER("-i"),
    STRING("-s");

    private String description;

    DataType(String description) {
        this.description = description;
    }

    public static DataType getValueForArg(String valueDescription) {
            for (DataType value: values()) {
                if (value.description.equals(valueDescription)) {
                    return value;
                }
            }
        return null;
    }

    // Определить тип данных
    public static DataType getTypeForSourceValues(List<Object> sourceValuesFromFile) {
        DataType dataType = DataType.INTEGER;

        for (Object element: sourceValuesFromFile) {
            if (!(element instanceof Integer)) {
                dataType = DataType.STRING;
                break;
            }
        }
        return dataType;
    }

    public String getDescription() {
        return description;
    }
}