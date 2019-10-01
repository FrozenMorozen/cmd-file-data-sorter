package com.company.param.type;

import com.company.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class ArgIndexTypeTest {

		@Test
		@DisplayName("Получить наименование для валидного индекса")
		void getNameForRightArgIndex() {
				for (int i = 0; i < Validator.ARGS_FULL_NORMAL_LENGTH; i++) {
						assertNotNull(ArgIndexType.getNameForArgIndex(i));
				}
		}

		@Test
		@DisplayName("Получить наименование для невалидного индекса")
		void getNameForWrongArgIndex() {
				assertNull(ArgIndexType.getNameForArgIndex(Validator.ARGS_FULL_NORMAL_LENGTH + 1));
				assertNull(ArgIndexType.getNameForArgIndex(Validator.ARGS_FULL_NORMAL_LENGTH + 2));
				assertNull(ArgIndexType.getNameForArgIndex(Validator.ARGS_FULL_NORMAL_LENGTH + 3));
				assertNull(ArgIndexType.getNameForArgIndex(Validator.ARGS_FULL_NORMAL_LENGTH + 4));
		}

}