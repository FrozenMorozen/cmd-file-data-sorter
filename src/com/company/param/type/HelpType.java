package com.company.param.type;

public enum HelpType {
		SHORT("-h"),
		FULL("-help");

	private String description;

	HelpType(String description) {
		this.description = description;
	}

	public static boolean checkValueForParam(String param) {
		for (HelpType value: values()) {
				if (value.description.equals(param)) {
						return true;
				}
		}
		return false;
	}
}
