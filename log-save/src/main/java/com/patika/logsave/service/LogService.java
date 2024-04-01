package com.patika.logsave.service;

import com.patika.logsave.entity.ErrorLog;
import com.patika.logsave.repository.ErrorLogRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final ErrorLogRepository repository;

    public LogService(ErrorLogRepository repository) {
        this.repository = repository;
    }

    public void save(ErrorLog errorLog) {
        repository.save(errorLog);
    }
}
