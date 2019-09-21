package com.company.service;

import java.io.File;
import java.util.List;

/**
	* Сервис для работы с файлами
	*/
public interface FileHandlerService {

		/**
			* Считать данные из файла
			* @param file Файл для чтения
			* @return коллекция считанных данных
			*/
		List<Object> readData(File file);

		/**
			* Записать данные в файл
			* @param data коллекция данных
			* @param file файл для записи
			*/
		void writeDataToFile(List<Object> data, File file);
}
