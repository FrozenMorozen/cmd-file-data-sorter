package com.company;

import com.company.exception.DataTypeParameterException;
import com.company.exception.EmptyFileDataException;
import com.company.param.type.DataType;
import com.company.service.FileHandlerService;

import java.util.Collections;
import java.util.List;

public class SourceValues {

    private List<Object> sourceValues;

    public void initSourceValues(FileHandlerService fileHandlerService, CmdParams cmdParams) {
        List<Object> sourceValuesFromFile = fileHandlerService.readData(cmdParams.getFileForReading());
        validateSourceValues(sourceValuesFromFile, cmdParams.getDataType());
        sourceValues = sourceValuesFromFile;
    }

    // Валидация коллекции объектов из исходного файла
    private void validateSourceValues(List<Object> sourceValuesFromFile, DataType dataTypeParam) {
        try {
            // Проверить полноту данных
            if (sourceValuesFromFile == Collections.EMPTY_LIST) {
                throw new EmptyFileDataException("Исходный файл не содержит данных.");
            }

            // Проверка соответствия между типом данных в файле и параметром из аргументов, заданного пользователем
            DataType actualDataType = getTypeForSorceValues(sourceValuesFromFile);
            if (!actualDataType.equals(dataTypeParam)) {
                throw new DataTypeParameterException("Параметр \"" + dataTypeParam.getDescription() + "\" не соответствует типу данных в исходном файле.");
            }

        } catch (EmptyFileDataException | DataTypeParameterException ignored) {}
    }

    // Определить тип данных
    private DataType getTypeForSorceValues(List<Object> sourceValuesFromFile) {
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

    public List<Object> getSourceValues() {
        return sourceValues;
    }
}
