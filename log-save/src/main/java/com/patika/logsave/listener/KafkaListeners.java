package com.patika.logsave.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patika.logsave.dto.ExceptionResponse;
import com.patika.logsave.entity.ErrorLog;
import com.patika.logsave.service.LogService;
import org.bson.types.ObjectId;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final LogService service;

    public KafkaListeners(LogService service) {
        this.service = service;
    }

    @KafkaListener(topics = "errorlog", groupId = "groupId")
    void listener(String data) {
        processMessage(data);
    }

    public void processMessage(String jsonMessage) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ExceptionResponse exceptionResponse = objectMapper.readValue(jsonMessage, ExceptionResponse.class);

            ObjectId objectId = new ObjectId();

            service.save(new ErrorLog(objectId, exceptionResponse.getMessage(), exceptionResponse.getHttpStatus()));
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

}
