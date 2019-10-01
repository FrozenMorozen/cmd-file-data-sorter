package com.company;

import com.company.exception.ArgsLengthException;
import com.company.exception.DataTypeParameterException;
import com.company.exception.OrderTypeException;
import com.company.param.type.DataType;
import com.company.param.type.OrderType;
import com.company.param.type.ArgIndexType;

import java.io.File;
import java.io.FileNotFoundException;

/**
	* Класс для агрегирования и валидации аргументов командной строки
	*/
public class ParamsAggregator {

    private static ParamsAggregator INSTANCE;

    private File fileForReading;
    private String fileNameForWriting;
    private DataType dataType;
    private OrderType orderType;

    private ParamsAggregator() {}

    public static ParamsAggregator getInstance() {
    		if (INSTANCE == null) {
    				INSTANCE = new ParamsAggregator();
    		}
    		return INSTANCE;
    }

    public void fillParams(String[] args) {

				    for (int i = 0; i < args.length; i++) {
						    String arg = args[i];

						    try {
								    ArgIndexType index = ArgIndexType.getNameForArgIndex(i);
								    if (index == null) {
										    throw new ArgsLengthException("Неверное количество параметров.");
								    }

								    switch (index) {
										    case SOURCE_FILE_NAME:
												    File fileForReading = new File(arg);
												    Validator.checkFileExist(fileForReading);
												    this.setFileForReading(fileForReading);
												    continue;

										    case WRITING_FILE_NAME:
												    this.setFileNameForWriting(arg);
												    continue;

										    case DATA_TYPE:
												    DataType argDataType = DataType.getValueForArg(arg);
												    if (argDataType == null) {
														    throw new DataTypeParameterException("Неверный параметр типа данных: \""+arg+"\"");
												    }
												    this.setDataType(argDataType);
												    continue;

										    case ORDER_TYPE:
												    OrderType argOrderType = OrderType.getValueForArg(arg);
												    if (argOrderType == null) {
														    throw new OrderTypeException("Неверный параметр сортировки: \""+ arg + "\"");
												    }
												    this.setOrderType(argOrderType);
								    }
						    } catch (ArgsLengthException | OrderTypeException | DataTypeParameterException ex) {
								    System.err.println(0);
						    } catch (FileNotFoundException e) {
								    System.err.println("Файл \""+fileForReading.getAbsolutePath() + "\" не существует");
								    System.exit(0);
						    }
				    }
    }

    public String getFileNameForWriting() {
        return fileNameForWriting;
    }

    private void setFileNameForWriting(String fileForWriting) {
        this.fileNameForWriting = fileForWriting;
    }

    public DataType getDataType() {
        return dataType;
    }

    private void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    private void setOrderType(OrderType order) {
        this.orderType = order;
    }

    public File getFileForReading() {
        return fileForReading;
    }

    private void setFileForReading(File fileForReading) {
    		this.fileForReading = fileForReading;
    }
}
