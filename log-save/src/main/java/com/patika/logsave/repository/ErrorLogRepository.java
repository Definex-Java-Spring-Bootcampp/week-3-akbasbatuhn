package com.patika.logsave.repository;

import com.patika.logsave.entity.ErrorLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorLogRepository extends MongoRepository<ErrorLog, Integer> {
}
