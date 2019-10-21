package com.company.service.impl;

import com.company.InsertionSort;
import com.company.ParamsAggregator;
import com.company.Validator;
import com.company.exception.ArgsLengthException;
import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.exception.HelpParameterException;
import com.company.param.type.HelpType;
import com.company.service.AppLauncherService;
import com.company.service.FileHandlerService;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static com.company.Validator.ARGS_HELP_NORMAL_LENGTH;

public class AppLauncherServiceImpl implements AppLauncherService {

		private static FileHandlerService fileHandlerService = new FileHandlerServiceImpl();
		private static Comparator comparator = new InsertionSort();

		private static int HELP_COMAND_INDEX = 0;

	@Override
	public void launch(String[] args) {
			try {
					Validator.validateParamsLength(args.length);
					if (args.length == ARGS_HELP_NORMAL_LENGTH && HelpType.checkValue(args[HELP_COMAND_INDEX])) {
							showHelp();
							return;
					}

					ParamsAggregator params = ParamsAggregator.getInstance();
					params.fillParams(args);

					List<Object> fileData = fileHandlerService.readData(params.getFileForReading());
					Validator.validateSourceValuesFromFile(fileData, params.getDataType());

					fileData.sort(comparator);

					fileHandlerService.writeDataToFile(fileData, new File(params.getFileNameForWriting()));
					showSuccessMessage(params);

			} catch (EmptyFileDataException | ArgsLengthException | DataTypeParameterException | HelpParameterException ex) {
					System.exit(0);
			}

	}

		private void showSuccessMessage(ParamsAggregator paramsAggregator) {
			StringBuilder successInfo = new StringBuilder();
			switch (paramsAggregator.getDataType()) {
					case STRING:
							successInfo.append("Строковые");
							break;
					case INTEGER:
							successInfo.append("Целочисленные");
							break;
			}
				successInfo.append(" данные из файла: \"")
												.append(paramsAggregator.getFileForReading().getAbsolutePath())
												.append("\" успешно записаны в файл: \"").append(paramsAggregator.getFileNameForWriting())
												.append("\" с сортировкой ");

				switch (paramsAggregator.getOrderType()) {
						case ASC:
								successInfo.append("по возрастанию");
								break;
						case DESC:
								successInfo.append("по убыванию");
								break;
				}
				successInfo.append(".");
				System.out.println(successInfo);
		}

		// Переделать
	private void showHelp() {
			System.out.println();
			System.out.println("  Usage:");
			System.out.println("  java -jar \"Sort File Content.jar\" path_or_name_of_input_file  path_or_name_of_output_file [-i | -s] [-d | -a]");
			System.out.println("   -s sort as strings or -i sort as integers");
			System.out.println("   -d descending sort or -a ascending sort");
			System.out.println();
	}

}