package com.patika.kredinbizdeservice.exceptions.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponse {

    private String message;
    private HttpStatus httpStatus;

}
