package com.company.exception;

abstract class AbstractExceptionMessage extends Throwable {
    private static String HELP_INFO = "Для вызова справки воспользуйтесь командой \"-h\" или \"-help\"";

    AbstractExceptionMessage(String message) {
        System.err.println(message + "\n" + HELP_INFO);
        System.exit(0);
    }
}
