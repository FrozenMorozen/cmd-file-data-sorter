package com.company.param.type;

import com.company.exception.HelpParameterException;

public enum HelpType {
		SHORT("-h"),
		FULL("-help");

	private String description;

	HelpType(String description) {
		this.description = description;
	}

	public static boolean checkValue(String argValue) throws HelpParameterException {
			for (HelpType value: values()) {
					if (value.description.equals(argValue)) {
							return true;
					}
			}
			throw new HelpParameterException("Неверный параметр: \"" + argValue + "\"");
	}

		public String getDescription() {
				return description;
		}
}
