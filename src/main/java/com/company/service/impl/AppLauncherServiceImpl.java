package com.company.service.impl;

import com.company.CmdParams;
import com.company.InsertionSort;
import com.company.Validator;
import com.company.exception.ArgsLengthException;
import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.param.type.HelpType;
import com.company.service.AppLauncherService;
import com.company.service.FileHandlerService;

import java.io.File;
import java.util.Collections;
import java.util.List;

import static com.company.Validator.ARGS_HELP_NORMAL_LENGTH;

public class AppLauncherServiceImpl implements AppLauncherService {

		//    @Inject
//    private FileHandlerService fileHandlerService;
		private static FileHandlerService fileHandlerService = new FileHandlerServiceImpl();

		private static int HELP_COMAND_INDEX = 0;

	@Override
	public void launch(String[] appParams) {

			try {
					Validator.validateParamsLength(appParams.length);
					if (appParams.length == ARGS_HELP_NORMAL_LENGTH && HelpType.checkValue(appParams[HELP_COMAND_INDEX])) {
							showHelp();
							return;
					}

					CmdParams cmdParams = CmdParams.getInstance();
					cmdParams.fillParams(appParams);

					List<Object> readingFileData = fileHandlerService.readData(cmdParams.getFileForReading());
					Validator.validateSourceValuesFromFile(readingFileData, cmdParams.getDataType());

					Collections.sort(readingFileData, new InsertionSort());

					fileHandlerService.writeDataToFile(readingFileData, new File(cmdParams.getFileNameForWriting()));
					showSuccessMessage(cmdParams);

			} catch (EmptyFileDataException | ArgsLengthException | DataTypeParameterException ex) {
					System.exit(0);
			}

	}

		private void showSuccessMessage(CmdParams cmdParams) {
			StringBuilder successInfo = new StringBuilder();
			switch (cmdParams.getDataType()) {
					case STRING:
							successInfo.append("Строковые");
							break;
					case INTEGER:
							successInfo.append("Целочисленные");
							break;
			}
				successInfo.append(" данные из файла \"").append(cmdParams.getFileForReading().getAbsolutePath())
												.append("\" успешно записаны в файл \"").append(cmdParams.getFileNameForWriting()).append("\" с сортировкой ");

				switch (cmdParams.getOrderType()) {
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
