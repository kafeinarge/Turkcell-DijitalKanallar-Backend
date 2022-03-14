package com.kafein.moviemanager.utils;


import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.exception.MovieManagerException;
import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.dto.response.Response;

public class ResponseUtil {

    public static void addResultIntoResponseObj(BaseResponse response, ErrorCodeAndDesc desc){
        response.setResponseCode(desc.getErrorCode());
        response.setResponseDesc(desc.getErrorDesc());
    }

    public static void addResultIntoResponseObj(BaseResponse response, MovieManagerException e){
        response.setResponseCode(e.getErrorCode());
        response.setResponseDesc(e.getMessage());
    }

    public static void addResultIntoResponseObj(BaseResponse response, Response clientResponse){

        if(clientResponse == null){
            response.setResponseCode(ErrorCodeAndDesc.SUCCESS.getErrorCode());
            response.setResponseDesc(ErrorCodeAndDesc.SUCCESS.getErrorDesc());
        } else {
            response.setResponseCode(clientResponse.getStatusCode());
            response.setResponseDesc(clientResponse.getStatusMessage());
        }
    }
}
