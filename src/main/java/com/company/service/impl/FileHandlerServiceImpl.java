package com.company.service.impl;

import com.company.service.FileHandlerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerServiceImpl implements FileHandlerService {

		@Override
		public List<Object> readData(File file) {
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

		@Override
		public void writeDataToFile(List<Object> data, File file) {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
						for (int i = 0; i < data.size(); i++) {
								writer.write((String) data.get(i));
								if (i != data.size() - 1) {
										writer.write("\n");
								}
						}
						writer.flush();

				} catch (FileNotFoundException e) {
						System.err.println("Не удалось найти файл: \"" + file.getAbsolutePath() + "\"");
				} catch (IOException e) {
						System.err.println("Ошибка записи");
				}
		}
}
