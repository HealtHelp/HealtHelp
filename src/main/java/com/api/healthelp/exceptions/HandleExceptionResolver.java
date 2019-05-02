package com.api.healthelp.exceptions;

import com.api.healthelp.model.dto.CrErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;

@ControllerAdvice
public class HandleExceptionResolver extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private LocalDateTime localDate = LocalDateTime.now();
    private CrErrorDTO crErrorDTO = new CrErrorDTO();

    public CrErrorDTO setBuildException(Exception ex){
        this.crErrorDTO.setMessage(ex.getMessage());
        this.crErrorDTO.setError(ex.getCause());
        this.crErrorDTO.setException(ex.getClass().toString());
        this.crErrorDTO.setTimestamp(this.localDate);
        return this.crErrorDTO;
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CrErrorDTO> handleLoginException(NullPointerException e) {
        logger.error(" -- ERROR Invalid credentials {}  ",e.getLocalizedMessage());
        setBuildException(e);
        this.crErrorDTO.setMessage("Invalid credentials");
        this.crErrorDTO.setStatus(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(this.crErrorDTO,HttpStatus.NOT_FOUND);
    }

    //org.postgresql.util.PSQLException
    @ExceptionHandler(org.postgresql.util.PSQLException.class)
    public ResponseEntity<CrErrorDTO> handleLoginException(org.postgresql.util.PSQLException e) {
        logger.error(" -- SQL ERROR Duplicate key  {}  ",e.getLocalizedMessage());
        setBuildException(e);
        this.crErrorDTO.setStatus(HttpStatus.CONFLICT);
        return new ResponseEntity<>(this.crErrorDTO,HttpStatus.NOT_FOUND);
    }
}
