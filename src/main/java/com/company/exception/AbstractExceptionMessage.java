package com.company.exception;

abstract class AbstractExceptionMessage extends Exception {

    AbstractExceptionMessage(String message) {
        System.err.println(message + "\n" + "Для вызова справки воспользуйтесь командой \"-h\" или \"-help\"");
    }
}
