package com.kafein.moviemanager.exception;

public class MovieManagerException extends Exception {

    private static final long serialVersionUID = 1L;

    private int errorCode;

    public MovieManagerException(String errorMessage) {
        super(errorMessage);
    }

    public MovieManagerException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
