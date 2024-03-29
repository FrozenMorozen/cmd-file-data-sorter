package com.company.param.type;

import lombok.Getter;

import java.util.List;

public enum DataType {
    INTEGER("-i"),
    STRING("-s");

    @Getter
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

    // Определить тип данных для колеекции
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

}