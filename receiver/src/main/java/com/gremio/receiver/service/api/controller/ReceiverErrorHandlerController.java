package com.gremio.receiver.service.api.controller;

import com.gremio.receiver.exceptions.KafkaException;
import com.gremio.receiver.service.api.responses.BadRequestErrorResponse;
import com.gremio.receiver.service.api.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestControllerAdvice
public class ReceiverErrorHandlerController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReceiverErrorHandlerController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptions(Exception e){
        String message = "Oops! Something went wrong :c";
        LOGGER.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(KafkaException.class)
    public ResponseEntity<ErrorResponse> exceptions(KafkaException e){
        String message = "Kafka error!. " + e.getMessage();
        LOGGER.error(message);
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorResponse(message, Calendar.getInstance().getTimeInMillis()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestErrorResponse> validationException(MethodArgumentNotValidException e){
        String message = "Oops! Something went wrong :c";


        final List<String> errors = new ArrayList<String>();

        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : e.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        LOGGER.info(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadRequestErrorResponse(message, errors, Calendar.getInstance().getTimeInMillis()));
    }


}
