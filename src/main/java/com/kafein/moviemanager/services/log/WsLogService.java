package com.kafein.moviemanager.services.log;

import com.kafein.moviemanager.model.base.BaseRequest;
import com.kafein.moviemanager.model.base.BaseResponse;
import com.kafein.moviemanager.model.entity.ServiceLog;
import com.kafein.moviemanager.services.activemq.ActiveMqSender;
import com.kafein.moviemanager.utils.MovieManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WsLogService {

    @Autowired
    ActiveMqSender activeMqSender;

    /**
     *
     * This method is used for post services
     *
     * @param request baseRequest
     * @param response baseResponse
     */
    public void createServiceLog(BaseRequest request, BaseResponse response, String serviceName, String serviceOperation){
        ServiceLog log = new ServiceLog();
        log.setOutDate(new Date());
        log.setServiceName(serviceName);
        log.setServiceOperation(serviceOperation);
        if (response != null && response.getResponseDesc() != null) {
            log.setResultCode(String.valueOf(response.getResponseCode()));
            log.setResultDesc(response.getResponseDesc());
            log.setHeaderApplication("REST_WEB_SERVICE_POST");
        }
        MovieManagerUtil.convertJson(log, request, response);
        activeMqSender.sendLogService(log);
    }

    /**
     *
     * @param response
     * @param serviceName
     * @param serviceOperation
     * @param serviceMethod
     * @param uriVariables
     */
    public void createServiceLog(BaseResponse response, String serviceName, String serviceOperation, String serviceMethod, Object... uriVariables){
        ServiceLog log = new ServiceLog();
        log.setOutDate(new Date());
        log.setServiceName(serviceName);
        log.setServiceOperation(serviceOperation);
        if (response != null && response.getResponseDesc() != null) {
            log.setResultCode(String.valueOf(response.getResponseCode()));
            log.setResultDesc(response.getResponseDesc());
            log.setHeaderApplication("REST_WEB_SERVICE_" + serviceMethod);
        }
        MovieManagerUtil.convertJson(log, uriVariables, response);
        activeMqSender.sendLogService(log);
    }

    /**
     *
     * This method is used for get services
     *
     * @param response baseResponse
     */
    public void createServiceLog(BaseResponse response, String serviceName, String serviceOperation){
        ServiceLog log = new ServiceLog();
        log.setOutDate(new Date());
        log.setServiceName(serviceName);
        log.setServiceOperation(serviceOperation);
        if (response != null && response.getResponseDesc() != null) {
            log.setResultCode(String.valueOf(response.getResponseCode()));
            log.setResultDesc(response.getResponseDesc());
            log.setHeaderApplication("REST_WEB_SERVICE_GET");
        }
        MovieManagerUtil.convertJson(log, null, response);
        activeMqSender.sendLogService(log);
    }
}
