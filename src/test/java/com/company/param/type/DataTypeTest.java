package com.company.param.type;

import com.company.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataTypeTest {

		private static String WRONG_DATA_TYPE_ARG = "-psjsjs";

		private List<Object> createIntegerList() {
				List<Object> rightList = new ArrayList<>();
				rightList.add(1);
				rightList.add(9);
				rightList.add(5);
				rightList.add(5);
				rightList.add(78);
				rightList.add(0);
				rightList.add(8);
				return rightList;
		}

		@Test
		@DisplayName("Получение типизированного параметра типа данных. Для валидного параметра")
		void getValueForRightArg() {
				for (DataType value: DataType.values()) {
						assertNotNull(DataType.getValueForArg(value.getDescription()));
				}
		}

		@Test
		@DisplayName("Получение типизированного параметра типа данных. Для невалидного параметра")
		void getValueForWrongArg() {
				assertNull(DataType.getValueForArg(WRONG_DATA_TYPE_ARG));
		}

		@Test
		@DisplayName("Получение типа данных для коллекции значений. Положительный кейс")
		void getRightDataTypeForList() {
				assertEquals(DataType.STRING, DataType.getTypeForSourceValues(TestData.createStringList()));
				assertEquals(DataType.INTEGER, DataType.getTypeForSourceValues(createIntegerList()));
		}

		@Test
		@DisplayName("Получение типа данных для коллекции значений. Негативный кейс")
		void getWrongDataTypeForList() {
				assertNotEquals(DataType.INTEGER, DataType.getTypeForSourceValues(TestData.createStringList()));
				assertNotEquals(DataType.STRING, DataType.getTypeForSourceValues(createIntegerList()));
		}
}