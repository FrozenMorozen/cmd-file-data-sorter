package com.company.param.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderTypeTest {

		private static String WRONG_ORDER_ARG = "-order";

		@Test
		@DisplayName("Положительный кейс")
		void getValueForRightArgs() {
				for (OrderType value: OrderType.values()) {
						assertNotNull(OrderType.getValueForArg(value.getDescription()));
				}
		}

		@Test
		@DisplayName("Негативный кейс")
		void getValueForWrongArgs() {
				assertNull(OrderType.getValueForArg(WRONG_ORDER_ARG));
		}
}