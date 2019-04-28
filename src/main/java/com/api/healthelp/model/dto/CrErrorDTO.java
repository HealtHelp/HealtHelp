package com.api.healthelp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrErrorDTO implements Serializable{
    private LocalDateTime timestamp;
    private HttpStatus status;
    private Throwable error;
    private String message;
    private String exception;

}



