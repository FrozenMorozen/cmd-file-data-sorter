package com.company.param.type;

import com.company.exception.DataTypeParameterException;

public enum DataType {
    INTEGER("-i"),
    STRING("-s");

    private String description;

    DataType(String description) {
        this.description = description;
    }

    public static DataType getValueForParam(String valueDescription) throws DataTypeParameterException {
        for (DataType value: values()) {
            if (value.description.equals(valueDescription)) {
                return value;
            }
        }
        throw new DataTypeParameterException("Неверный параметр типа данных.");
    }

    public String getDescription() {
        return description;
    }
}