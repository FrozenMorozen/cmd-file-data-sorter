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

    public static void checkFileExist(File file) throws FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
    }

    // Валидация коллекции объектов из исходного файла
    public static void validateSourceValuesFromFile(List<Object> sourceValuesFromFile, DataType dataTypeFromArgs) throws EmptyFileDataException, DataTypeParameterException{
        // Проверить полноту данных
        if (sourceValuesFromFile == null || sourceValuesFromFile.size() == 0) {
            throw new EmptyFileDataException("Исходный файл не содержит данных.");
        }

        // Проверка соответствия между фактическим типом данных в файле и параметром из аргументов, заданного пользователем
        DataType actualDataType = DataType.getTypeForSourceValues(sourceValuesFromFile);
        if (!actualDataType.equals(dataTypeFromArgs)) {
            throw new DataTypeParameterException("Параметр \"" + dataTypeFromArgs.getDescription() + "\" не соответствует типу данных в исходном файле.");
        }
    }
}
