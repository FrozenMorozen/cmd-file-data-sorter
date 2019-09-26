package com.company.param.type;

import com.company.exception.ArgsLengthException;

public enum ParamIndexType {
    SOURCE_FILE_NAME(0),
    WRITING_FILE_NAME(1),
    DATA_TYPE(2),
    ORDER_TYPE(3);

    private int position;

    ParamIndexType(int position) {
        this.position = position;
    }

    public static ParamIndexType getValueForIndex(int index) {
        try {
            for (ParamIndexType value: values()) {
                if (value.position == index) {
                    return value;
                }
            }
            throw new ArgsLengthException("Неверное количество параметров.");
        } catch (ArgsLengthException ignored) {
            System.exit(0);
        }
        return null;
    }
}
