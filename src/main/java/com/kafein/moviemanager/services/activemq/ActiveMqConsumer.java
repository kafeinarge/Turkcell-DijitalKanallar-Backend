package com.kafein.moviemanager.services.activemq;

import com.kafein.moviemanager.model.entity.ServiceLog;
import com.kafein.moviemanager.repository.ServiceLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

import static com.kafein.moviemanager.config.ActiveMQConfig.LOG_SERVICE_QUEUE;

@Slf4j
@Component
public class ActiveMqConsumer {

    @Autowired
    ServiceLogRepository serviceLogRepository;

    @JmsListener(destination = LOG_SERVICE_QUEUE)
    public void receiveLogService(@Payload ServiceLog serviceLog, @Headers MessageHeaders headers,
                                  Message message, Session session){
        try {
            serviceLogRepository.save(serviceLog);
        } catch (Exception e) {
            log.error("Log service could not add system", e);
        }

    }

}
