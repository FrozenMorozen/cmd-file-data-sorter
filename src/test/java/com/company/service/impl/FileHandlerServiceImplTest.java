package com.company.service.impl;

import com.company.service.FileHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.company.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileHandlerServiceImplTest {

		private FileHandlerService fileHandlerService;

		@BeforeEach
		void setUp() {
				fileHandlerService = new FileHandlerServiceImpl();
		}

		@Test
		void readDataForCorrectPath() {
				createTestFile(TEST_FILE_NAME);
				assertNotNull(fileHandlerService.readData(new File(TEST_FILE_NAME)));
				deleteTestFile(TEST_FILE_NAME);
		}

		@Test
		void writeDataToFile() {
				File fileForWriting = new File(FILE_NAME_FOR_WRITING);
				fileHandlerService.writeDataToFile(DATA_FOR_WRITING, fileForWriting);
				assertEquals(DATA_FOR_WRITING, fileHandlerService.readData(fileForWriting));
		}
}