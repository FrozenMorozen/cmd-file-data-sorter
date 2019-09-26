package com.company.param.type;

import com.company.exception.HelpParameterException;

public enum HelpType {
		SHORT("-h"),
		FULL("-help");

	private String description;

	HelpType(String description) {
		this.description = description;
	}

	public static boolean checkValue(String param) {
			try {
					for (HelpType value: values()) {
							if (value.description.equals(param)) {
									return true;
							}
					}
					throw new HelpParameterException("Неверный параметр: \""+param+"\"");
			} catch (HelpParameterException ex) {
					System.exit(0);
			}
			return false;
	}
}
