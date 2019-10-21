package com.company;

import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.param.type.DataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.company.TestData.*;
import static com.company.Validator.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

		@Test
		@DisplayName("Валидация 4 параметров запуска")
		void validateRightFullParamsLength() {
				assertDoesNotThrow(()->validateParamsLength(ARGS_FULL_NORMAL_LENGTH));
		}

		@Test
		@DisplayName("Валидация 1 параметра запуска")
		void validateRightHelpParamsLength() {
				assertDoesNotThrow(()->validateParamsLength(ARGS_HELP_NORMAL_LENGTH));
		}

		@Test
		@DisplayName("Ошибка валидации неверного количества параметров запуска")
		void validateWrongFullParamsLength() {
				assertThrows(Exception.class, ()-> validateParamsLength(TestData.WRONG_FULL_ARGS_LENGTH));
		}

		@Test
		@DisplayName("Валидация существующего файла для чтения")
		void checkRightFileExist() {
				File testFile = createTestFile(TEST_FILE_NAME);
				assertDoesNotThrow(()->checkFileExist(new File(TEST_FILE_NAME)));
				deleteTestFile(testFile);
		}

		@Test
		@DisplayName("Ошибка при валидации несуществующего файла для чтения")
		void checkWrongFileExist() {
				assertThrows(Exception.class, ()-> checkFileExist(new File("njdnjnd/sdsdd/sd/dsds/sdsd")));
		}

		@Test
		@DisplayName("Валидация корректных  данных, считанных из файла")
		void validateRightSourceValuesFromFile() {
				List<Object> testStringList = TestData.createStringList();
				assertNotNull(testStringList);
				assertTrue(testStringList.size() != 0);
				assertEquals(DataType.STRING, DataType.getTypeForSourceValues(testStringList));

				assertDoesNotThrow(()->validateSourceValuesFromFile(testStringList, DataType.STRING));
		}

		@Test
		@DisplayName("Ошибка при валидации пустой коллекции")
		void validateWrongSourceValues() {
				List<Object> wrongTestList = null;
				assertThrows(EmptyFileDataException.class, ()->validateSourceValuesFromFile(wrongTestList, DataType.STRING));
		}

		@Test
		@DisplayName("Ошибка при валидации коллекции не соответсвующей типу данных из параметров запуска")
		void validateWrongDataTypeForSourceValues() {
				List<Object> testStringList = TestData.createStringList();
				DataType dataTypeFromArgs = DataType.INTEGER;
				assertNotNull(testStringList);
				assertTrue(testStringList.size() != 0);
				assertNotEquals(dataTypeFromArgs, DataType.getTypeForSourceValues(testStringList));

				assertThrows(DataTypeParameterException.class, ()->validateSourceValuesFromFile(testStringList, dataTypeFromArgs));
		}
}