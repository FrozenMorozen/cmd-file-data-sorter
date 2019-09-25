package com.company.service.impl;

import com.company.service.FileHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

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
				File fileForReading = new File(RIGHT_FILE_NAME_FOR_READING);
				List<Object> readingData = fileHandlerService.readData(fileForReading);
				assertNotNull(readingData);
		}

		@Test
		void writeDataToFile() {
				File fileForWriting = new File(FILE_NAME_FOR_WRITING);
				fileHandlerService.writeDataToFile(DATA_FOR_WRITING, fileForWriting);
				assertEquals(DATA_FOR_WRITING, fileHandlerService.readData(fileForWriting));
		}
}