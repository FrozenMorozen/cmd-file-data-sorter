package com.company.param.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.company.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class DataTypeTest {

		@Test
		@DisplayName("Получение типизированного параметра типа данных. Для валидного параметра")
		void getValueForRightArg() {
				assertNotNull(DataType.getValueForArg(RIGHT_STRING_DATA_TYPE_ARG));
				assertNotNull(DataType.getValueForArg(RIGHT_INTEGER_DATA_TYPE_ARG));
		}

		@Test
		@DisplayName("Получение типизированного параметра типа данных. Для невалидного параметра")
		void getValueForWrongArg() {
				assertNull(DataType.getValueForArg(WRONG_DATA_TYPE_ARG));
		}

		@Test
		@DisplayName("Получение типа данных для коллекции значений. Положительный кейс")
		void getRightDataTypeForList() {
				assertEquals(DataType.STRING, DataType.getTypeForSourceValues(createStringList()));
				assertEquals(DataType.INTEGER, DataType.getTypeForSourceValues(createIntegerList()));
		}

		@Test
		@DisplayName("Получение типа данных для коллекции значений. Негативный кейс")
		void getWrongDataTypeForList() {
				assertNotEquals(DataType.INTEGER, DataType.getTypeForSourceValues(createStringList()));
				assertNotEquals(DataType.STRING, DataType.getTypeForSourceValues(createIntegerList()));
		}
}