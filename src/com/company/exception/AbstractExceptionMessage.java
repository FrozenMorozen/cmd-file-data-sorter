package com.company.exception;

abstract class AbstractExceptionMessage extends Throwable {
    private static String HELP_INFO = "\nДля вызова справки воспользуйтесь командой -h/-help";

    AbstractExceptionMessage(String message) {
        super(message + HELP_INFO);
    }
}
