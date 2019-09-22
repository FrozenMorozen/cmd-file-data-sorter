package com.company;

import com.company.param.type.DataType;
import com.company.param.type.OrderType;
import com.company.param.type.ParamIndexType;

import java.io.File;
import java.io.FileNotFoundException;

/**
	* Класс для агрегирования и валидации аргументов командной строки
	*/
public class CmdParams {

    private static CmdParams INSTANCE;

    private File fileForReading;
    private String fileNameForWriting;
    private DataType dataType;
    private OrderType orderType;

    private CmdParams() {}

    public static CmdParams getInstance() {
    		if (INSTANCE == null) {
    				INSTANCE = new CmdParams();
    		}
    		return INSTANCE;
    }

    public void fillParams(String[] args) {

				    for (int i = 0; i < args.length; i++) {
						    String arg = args[i];
						    ParamIndexType index = ParamIndexType.getValueForIndex(i);

						    switch (index) {
								    case SOURCE_FILE_NAME:
										    this.setFileForReading(new File(arg));
										    continue;
								    case WRITING_FILE_NAME:
										    this.setFileNameForWriting(arg);
										    continue;
								    case DATA_TYPE:
										    this.setDataType(DataType.getValueForParam(arg));
										    continue;
								    case ORDER_TYPE:
										    this.setOrderType(OrderType.getValueForDescription(arg));
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
				    try {
						    if (!fileForReading.exists()) {
								    throw new FileNotFoundException();
						    }
						    this.fileForReading = fileForReading;
				    } catch (FileNotFoundException e) {
						    System.err.println("\""+fileForReading.getAbsolutePath() + "\" не существует");
						    System.exit(0);
				    }
    }
}
