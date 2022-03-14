package com.kafein.moviemanager.services.activemq;


import com.kafein.moviemanager.model.entity.ServiceLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.kafein.moviemanager.config.ActiveMQConfig.LOG_SERVICE_QUEUE;


@Slf4j
@Service
public class ActiveMqSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     *
     * @param serviceLog
     */
    public void sendLogService(ServiceLog serviceLog) {
        log.info("sending with convertAndSend() to queue <" + serviceLog + ">");
        jmsTemplate.convertAndSend(LOG_SERVICE_QUEUE, serviceLog);
    }
}
