package com.kafein.moviemanager.enums;

public enum ErrorCodeAndDesc {

    SUCCESS(1000, "Success"),
    JSON_PARSE_ERROR(1001, "Client response parse exception"),
    GENERAL_ERROR(-1, "General Error");

    private int errorCode;
    private String errorDesc;

    ErrorCodeAndDesc(int errorCode, String errorDesc){
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
