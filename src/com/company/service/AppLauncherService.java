package com.company.service;

/**
 * Интерфейс запуска приложения
 */
public interface AppLauncherService {

	/**
	 * Запустить приложение
	 * @param appParams параметры приложения
	 */
	void launch(String[] appParams);

	// Фейковый метод для теста
	default void fakeLaunch(String[] appParams) {

	}
}
