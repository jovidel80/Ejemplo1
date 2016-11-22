package com.joseoliveros.aplicacion.bo;

public class DataBaseException extends RuntimeException {

    private static final long serialVersionUID = 1419366113154644458L;

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
