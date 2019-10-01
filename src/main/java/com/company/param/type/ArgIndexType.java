package com.company.param.type;

public enum ArgIndexType {
    SOURCE_FILE_NAME(0),
    WRITING_FILE_NAME(1),
    DATA_TYPE(2),
    ORDER_TYPE(3);

    private int position;

    ArgIndexType(int position) {
        this.position = position;
    }

    public static ArgIndexType getNameForArgIndex(int index) {
		    for (ArgIndexType value: values()) {
				    if (value.position == index) {
						    return value;
				    }
		    }
		    return null;
    }
}
