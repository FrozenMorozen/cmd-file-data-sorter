package com.company.param.type;

import com.company.exception.DataTypeParameterException;

import java.util.List;

public enum DataType {
    INTEGER("-i"),
    STRING("-s");

    private String description;

    DataType(String description) {
        this.description = description;
    }

    public static DataType getValueForParam(String valueDescription) {
        try {
            for (DataType value: values()) {
                if (value.description.equals(valueDescription)) {
                    return value;
                }
            }
            throw new DataTypeParameterException("Неверный параметр типа данных: \""+valueDescription+"\"");
        } catch (DataTypeParameterException ex) {
            System.exit(0);
        }
        return null;
    }

    // Определить тип данных
    public static DataType getTypeForSourceValues(List<Object> sourceValuesFromFile) {
        DataType dataType = DataType.STRING;

        for (Object element: sourceValuesFromFile) {
            if (element instanceof Integer) {
                if (!dataType.equals(DataType.INTEGER)) {
                    dataType = DataType.INTEGER;
                }
            } else {
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