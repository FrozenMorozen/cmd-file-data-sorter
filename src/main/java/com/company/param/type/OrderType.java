package com.company.param.type;

public enum OrderType {
		ASC("-a"),
		DESC("-d");

		private String description;

		OrderType(String description) {
				this.description = description;
		}

		public static OrderType getValueForArg(String valueDescription) {
				for (OrderType value: values()) {
						if (value.description.equals(valueDescription)) {
								return value;
						}
				}
				return null;
		}

		public String getDescription() {
				return description;
		}
}
