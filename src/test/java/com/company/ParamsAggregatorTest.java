package com.company;

import com.company.param.type.DataType;
import com.company.param.type.OrderType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.company.TestData.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParamsAggregatorTest {

		@Test
		@DisplayName("Корректность заполнения агрегатора параметров")
		void fillParams() {

				File fileForReading =createTestFile(TEST_FILE_NAME);
				if (fileForReading != null) {
						// Создать массив с корректными аргументами
						String[] rightArguments = {
														fileForReading.getAbsolutePath(),
														FILE_NAME_FOR_WRITING,
														DataType.STRING.getDescription(),
														OrderType.ASC.getDescription()
						};

						ParamsAggregator paramsAggregator = ParamsAggregator.getInstance();
						paramsAggregator.fillParams(rightArguments);

						assertNotNull(paramsAggregator.getFileForReading());
						assertNotNull(paramsAggregator.getFileNameForWriting());
						assertNotNull(paramsAggregator.getDataType());
						assertNotNull(paramsAggregator.getOrderType());

						assertTrue(deleteTestFile(fileForReading.getAbsolutePath()));
				}


		}
}