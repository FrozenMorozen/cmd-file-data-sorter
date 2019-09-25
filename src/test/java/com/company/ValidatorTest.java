package com.company;

import com.company.exception.ArgsLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.company.TestData.*;
import static com.company.Validator.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

		@Test
		void validateRightFullParamsLength() {
				try {
						validateParamsLength(ARGS_FULL_NORMAL_LENGTH);
						assertTrue(true);
				} catch (ArgsLengthException e) {
						assertTrue(false);
				}
		}

		@Test
		@DisplayName("throws ArgsLengthException when validateParamsLength")
		void validateWrongFullParamsLength() {
//				Throwable exception =assertThrows(ArgsLengthException.class, ()-> validateParamsLength(WRONG_FULL_ARGS_LENGTH));
//				assertNotNull(exception);
		}

		@Test
		void validateRightHelpParamsLength() {
				try {
						validateParamsLength(ARGS_HELP_NORMAL_LENGTH);
						assertTrue(true);
				} catch (ArgsLengthException e) {
						assertNull(e);
				}
		}

		@Test
		@DisplayName("throws ArgsLengthException when validateParamsLength")
		void validateWrongHelpParamsLength() {

		}

		@Test
		void checkRightFileExist() {
				assertNotNull(createTestFile(TEST_FILE_NAME));
				Validator.checkFileExist(new File(TEST_FILE_NAME));
				assertTrue(deleteTestFile(TEST_FILE_NAME));
		}

		@Test
		void checkWrongFileExist() {
		}

		@Test
		void validateSourceValuesFromFile() {
		}
}