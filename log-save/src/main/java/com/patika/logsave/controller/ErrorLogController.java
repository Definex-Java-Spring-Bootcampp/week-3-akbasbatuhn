package com.patika.logsave.controller;

import com.patika.logsave.entity.ErrorLog;
import com.patika.logsave.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/errorlog")
public class ErrorLogController {

    private final LogService service;

    public ErrorLogController(LogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveErrorLog(@RequestBody ErrorLog errorLog) {
        service.save(errorLog);
        return ResponseEntity.ok().build();
    }
}
