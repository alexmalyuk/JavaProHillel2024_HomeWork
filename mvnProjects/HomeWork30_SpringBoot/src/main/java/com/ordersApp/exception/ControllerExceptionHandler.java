package com.ordersApp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = {
            Exception.class})
    public ResponseEntity<?> handleInvalidTopUpTypeException(Exception ex) {
        log.error(ex.getMessage());
        log.error(ex.getStackTrace().toString());
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            OrderNotFoundException.class})
    public ResponseEntity<?> handleOrderNotFoundException(Exception ex) {
        String msg = String.format("Can not find order by id : %s", ex.getMessage());
        log.error(msg);
        return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
    }
}
