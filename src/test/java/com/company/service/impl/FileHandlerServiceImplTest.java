package com.company.service.impl;

import com.company.TestData;
import com.company.service.FileHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.company.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class FileHandlerServiceImplTest {

		private FileHandlerService fileHandlerService;

		@BeforeEach
		void setUp() {
				fileHandlerService = new FileHandlerServiceImpl();
		}

		@Test
		@DisplayName("Корректность чтения данных из файла")
		void readDataForCorrectPath() {
				List<Object> expectedList = createStringList();
				File fileForReading =createTestFileWithData(TEST_FILE_NAME, expectedList);

				if (fileForReading != null) {
						List<Object> actualList = fileHandlerService.readData(fileForReading);
						assertNotNull(actualList);
						assertEquals(expectedList, actualList);
				}

				deleteTestFile(fileForReading);
		}

		@Test
		@DisplayName("Корректность записи данных в файл")
		void writeDataToFile() {
				File fileForWriting = new File(FILE_NAME_FOR_WRITING);
				fileHandlerService.writeDataToFile(DATA_FOR_WRITING, fileForWriting);
				assertEquals(DATA_FOR_WRITING, TestData.readDataFromTestFile(fileForWriting));
		}
}