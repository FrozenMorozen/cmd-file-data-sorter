package com.company.param.type;

import com.company.exception.OrderTypeException;

public enum OrderType {
    ASC("-a"),
    DESC("-d");

    private String description;

    OrderType(String description) {
        this.description = description;
    }

    public static OrderType getValueForDescription(String valueDescription) {
        try {
            for (OrderType value: values()) {
                if (value.description.equals(valueDescription)) {
                    return value;
                }
            }
            throw new OrderTypeException("Неверный параметр сортировки.");

        } catch (OrderTypeException ex) {
            System.exit(0);
        }
        return null;
    }
}
