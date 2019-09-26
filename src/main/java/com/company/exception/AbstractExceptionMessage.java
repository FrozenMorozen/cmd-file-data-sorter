package com.company.exception;

abstract class AbstractExceptionMessage extends Exception {
    private static String HELP_INFO = "Для вызова справки воспользуйтесь командой \"-h\" или \"-help\"";

    AbstractExceptionMessage(String message) {
        System.err.println(message + "\n" + HELP_INFO);
    }
}
