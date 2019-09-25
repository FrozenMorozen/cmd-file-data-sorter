package com.company;

import com.company.exception.ArgsLengthException;
import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.param.type.DataType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Validator {

    public static int ARGS_HELP_NORMAL_LENGTH = 1;
    public static int ARGS_FULL_NORMAL_LENGTH = 4;

    // Валидация количества переданных пользователем параметров
    public static void validateParamsLength(int argsCount) throws ArgsLengthException{
        if (argsCount != ARGS_FULL_NORMAL_LENGTH && argsCount != ARGS_HELP_NORMAL_LENGTH) {
            throw new ArgsLengthException("Неверное количество параметров.");
        }
    }

    public static void checkFileExist(File file) {
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл \""+file.getAbsolutePath() + "\" не существует");
            System.exit(0);
        }
    }

    // Валидация коллекции объектов из исходного файла
    public static void validateSourceValuesFromFile(List<Object> sourceValuesFromFile, DataType dataTypeParam) throws EmptyFileDataException, DataTypeParameterException{
        // Проверить полноту данных
        if (sourceValuesFromFile.size() == 0) {
            throw new EmptyFileDataException("Исходный файл не содержит данных.");
        }

        // Проверка соответствия между типом данных в файле и параметром из аргументов, заданного пользователем
        DataType actualDataType = getTypeForSourceValues(sourceValuesFromFile);
        if (!actualDataType.equals(dataTypeParam)) {
            throw new DataTypeParameterException("Параметр \"" + dataTypeParam.getDescription() + "\" не соответствует типу данных в исходном файле.");
        }
    }

    // Определить тип данных
    private static DataType getTypeForSourceValues(List<Object> sourceValuesFromFile) {
        DataType dataType = DataType.STRING;

        for (Object element: sourceValuesFromFile) {
            if (element instanceof Integer) {
                if (!dataType.equals(DataType.INTEGER)) {
                    dataType = DataType.INTEGER;
                }
            } else {
                dataType = DataType.STRING;
                break;
            }
        }
        return dataType;
    }
}
