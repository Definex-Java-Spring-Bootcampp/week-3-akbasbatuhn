package com.patika.logsave.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("ErrorLogs")
public class ErrorLog {

    @Id
    private ObjectId id;
    private String message;
    private HttpStatus errorCode;

    public ErrorLog(String message, HttpStatus httpStatus) {
        this.message = message;
        this.errorCode = httpStatus;
    }
}
