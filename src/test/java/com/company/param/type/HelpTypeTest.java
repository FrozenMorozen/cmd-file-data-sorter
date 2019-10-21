package com.company.param.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HelpTypeTest {

		private static String WRONG_HELP_ARG = "-hehe";

		@Test
		@DisplayName("Проверить все валидные параметры вызова справки")
		void checkRightValues() {
				for (HelpType value: HelpType.values()) {
						assertDoesNotThrow(()->HelpType.checkValue(value.getDescription()));
				}
		}

		@Test
		@DisplayName("Проверить невалидный параметр вызова справки")
		void checkWrongValues() {
				assertThrows(Exception.class, ()->HelpType.checkValue(WRONG_HELP_ARG));
		}
}