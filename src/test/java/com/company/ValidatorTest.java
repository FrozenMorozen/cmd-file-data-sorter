package com.company;

import com.company.exception.ArgsLengthException;
import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.param.type.DataType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.company.TestData.*;
import static com.company.Validator.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

		@Test
		@DisplayName("Валидация 4 параметров запуска")
		void validateRightFullParamsLength() throws ArgsLengthException {
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
				assertThrows(Exception.class, ()-> validateParamsLength(WRONG_FULL_ARGS_LENGTH));
		}

		@Test
		@DisplayName("Валидация существующего файла для чтения")
		void checkRightFileExist() {
				assertNotNull(createTestFile(TEST_FILE_NAME));
				assertDoesNotThrow(()->checkFileExist(new File(TEST_FILE_NAME)));
				assertTrue(deleteTestFile(TEST_FILE_NAME));
		}

		@Test
		@DisplayName("Ошибка при валидации несуществующего файла для чтения")
		void checkWrongFileExist() {
				assertThrows(Exception.class, ()-> checkFileExist(new File(WRONG_FILE_NAME)));
		}

		@Test
		@DisplayName("Валидация корректной коллекции данных, считанных из файла")
		void validateRightSourceValuesFromFile() {
				assertNotNull(RIGHT_STRING_LIST_FOR_VALIDATE);
				assertTrue(RIGHT_STRING_LIST_FOR_VALIDATE.size() != 0);
				assertEquals(DataType.STRING, DataType.getTypeForSourceValues(RIGHT_STRING_LIST_FOR_VALIDATE));

				assertDoesNotThrow(()->validateSourceValuesFromFile(RIGHT_STRING_LIST_FOR_VALIDATE, DataType.STRING));
		}

		@Test
		@DisplayName("Ошибка при валидации пустой коллекции")
		void validateWrongSourceValues() {
				assertNull(WRONG_LIST_FOR_VALIDATE);
				assertThrows(EmptyFileDataException.class, ()->validateSourceValuesFromFile(WRONG_LIST_FOR_VALIDATE, DataType.STRING));
		}

		@Test
		@DisplayName("Ошибка при валидации коллекции не соответсвующей типу данных из параметров запуска")
		void validateWrongDataTypeForSourceValues() {
				DataType dataTypeFromArgs = DataType.INTEGER;
				assertNotNull(RIGHT_STRING_LIST_FOR_VALIDATE);
				assertTrue(RIGHT_STRING_LIST_FOR_VALIDATE.size() != 0);
				assertNotEquals(dataTypeFromArgs, DataType.getTypeForSourceValues(RIGHT_STRING_LIST_FOR_VALIDATE));

				assertThrows(DataTypeParameterException.class, ()->validateSourceValuesFromFile(RIGHT_STRING_LIST_FOR_VALIDATE, dataTypeFromArgs));
		}
}