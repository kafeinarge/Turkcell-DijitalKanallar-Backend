package com.kafein.moviemanager.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafein.moviemanager.enums.ErrorCodeAndDesc;
import com.kafein.moviemanager.model.dto.response.AccountResponse;
import com.kafein.moviemanager.model.dto.response.Response;
import com.kafein.moviemanager.model.entity.ServiceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Slf4j
public class MovieManagerUtil {

    public static void convertJson(final ServiceLog serviceLog, final Object request, final Object response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        if (request != null) {
            try {
                serviceLog.setInParameters(mapper.writeValueAsString(request));
            } catch (Exception e) {
                log.error("setInParameters: " + e.getMessage(), e);
            }
        }
        if (response != null) {
            try {
                serviceLog.setOutParameters(mapper.writeValueAsString(response));
            } catch (Exception e) {
                log.error("setOutParameters: " + e.getMessage(), e);
            }
        }
    }

    public static String toJson(final Object request) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        if (request != null) {
            try {
                return mapper.writeValueAsString(request);
            } catch (Exception e) {
                log.error("setInParameters: " + e.getMessage(), e);
                return "ERROR";
            }
        }
        return null;
    }


    public static HttpEntity<String> generateHttpRequest(Object loginInfo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpRequest =
                new HttpEntity<String>(MovieManagerUtil.toJson(loginInfo), headers);
        return httpRequest;
    }

    public static Response jsonStringToObjet(String jsonString){
        Response response = new Response();
        try {
            response = new ObjectMapper().readValue(jsonString, Response.class);
        } catch (JsonProcessingException e) {
            log.error("Client response parse Exception: " + e.getMessage(), e);
            response.setSuccess(false);
            response.setStatusMessage(ErrorCodeAndDesc.JSON_PARSE_ERROR.getErrorDesc());
            response.setStatusCode(ErrorCodeAndDesc.JSON_PARSE_ERROR.getErrorCode());
        }
        return response;
    }
}
