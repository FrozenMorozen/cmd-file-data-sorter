package com.company.service.impl;

import com.company.CmdParams;
import com.company.InsertionSort;
import com.company.SourceValues;
import com.company.exception.ArgsLengthException;
import com.company.param.type.HelpType;
import com.company.service.AppLauncherService;
import com.company.service.FileHandlerService;

import java.io.File;
import java.util.Collections;

public class AppLauncherServiceImpl implements AppLauncherService {

		//    @Inject
//    private FileHandlerService fileHandlerService;
		private static FileHandlerService fileHandlerService = new FileHandlerServiceImpl();

		private static int ARGS_FULL_NORMAL_LENGTH = 4;
		private static int ARGS_HELP_NORMAL_LENGTH = 1;
		private static int HELP_COMAND_INDEX = 0;

	@Override
	public void launch(String[] appParams) {
			// Если задан всего один параметр и валидация прошла без ошибок - то вызвана справка
			// Смотрится костыльно конечно, пока ничего лучше не придумал
			if (validateParamsLength(appParams) == ARGS_HELP_NORMAL_LENGTH) {
					return;
			}

		CmdParams cmdParams = CmdParams.getInstance();
		cmdParams.fillCmdParams(appParams);

		SourceValues sourceValues = new SourceValues();
			sourceValues.initSourceValues(fileHandlerService, cmdParams);

		Collections.sort(sourceValues.getSourceValues(), new InsertionSort());

			fileHandlerService.writeDataToFile(sourceValues.getSourceValues(), new File(cmdParams.getFileNameForWriting()));
	}

	private void showHelp() {
			System.out.println();
			System.out.println("  Usage:");
			System.out.println("  java -jar \"Sort File Content.jar\" path_or_name_of_input_file  path_or_name_of_output_file [-i | -s] [-d | -a]");
			System.out.println("   -s sort as strings or -i sort as integers");
			System.out.println("   -d descending sort or -a ascending sort");
			System.out.println();
	}

	private int validateParamsLength(String[] appParams) {
			int argsCount = appParams.length;
			try {
					if (argsCount != ARGS_FULL_NORMAL_LENGTH && argsCount != ARGS_HELP_NORMAL_LENGTH) {
							throw new ArgsLengthException("Неверное количество параметров.");
					}
			} catch (ArgsLengthException ignored) {}

			if (argsCount == 1 && HelpType.checkValueForParam(appParams[HELP_COMAND_INDEX]) ) {
					showHelp();
			}
			return argsCount;
	}
}
