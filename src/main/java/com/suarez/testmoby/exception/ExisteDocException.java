package com.suarez.testmoby.exception;

public class ExisteDocException extends RuntimeException {
    public ExisteDocException() {
        super("El documento ya existe");
    }
}
