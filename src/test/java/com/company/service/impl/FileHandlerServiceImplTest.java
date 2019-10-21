package com.company.service.impl;

import com.company.TestData;
import com.company.service.FileHandlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

		private File createTestFileWithData(String fileName, List data) {
				try {
						File testFile = new File(String.valueOf(Files.createFile(Paths.get(fileName))));
						BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
						for (int i = 0; i < data.size(); i++) {
								writer.write((String) data.get(i));
								if (i != data.size() - 1) {
										writer.write("\n");
								}
						}
						writer.flush();
						return testFile;

				} catch (IOException e) {
						return null;
				}
		}

		private List<Object> readDataFromTestFile(File file) {
				List<Object> fileData = new ArrayList<>();

				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
						while (reader.ready()) {
								String line = reader.readLine();
								if (!line.isEmpty()) {
										fileData.add(line);
								} else {
										break;
								}
						}
				} catch (IOException ex) {
						ex.printStackTrace();
				}
				return fileData;
		}

		@Test
		@DisplayName("Корректность чтения данных из файла")
		void readDataForCorrectPath() {
				List<Object> expectedList = TestData.createStringList();
				File fileForReading =createTestFileWithData(TestData.FILE_NAME_FOR_CREATING, expectedList);

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
				List<Object> dataForWriting = TestData.createStringList();
				File fileForWriting = new File(TestData.FILE_NAME_FOR_WRITING);
				fileHandlerService.writeDataToFile(dataForWriting, fileForWriting);
				assertEquals(dataForWriting, readDataFromTestFile(fileForWriting));
		}
}