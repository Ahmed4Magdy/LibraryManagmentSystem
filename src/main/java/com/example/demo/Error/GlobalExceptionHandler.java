package com.example.demo.Error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


//    @ExceptionHandler(RecordNotFoundException.class)
//    public ResponseEntity<?>HandlerRecordNotFound(RecordNotFoundException ex){
//
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ex.getMessage());
//    }
//
//


    //because I need in response json is has object (er)
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> HandlerRecordNotFound(RecordNotFoundException ex) {

        ErrorResponse er = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(er);
    }


    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<?> HandlerDuplicateRecordException(DuplicateRecordException ex) {

        ErrorResponse er = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(er);
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        //ex.getBindingResult().getFieldErrors() provides a list of validation errors for each field.
//        ex.getBindingResult().getFieldErrors()
//                //  The forEach loop extracts the field name and error message
//                .forEach(error ->
//                        errors.put(error.getField(), error.getDefaultMessage())
//                );
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> errors = new ArrayList<String>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getDefaultMessage());
        }

        ErrorResponse error = new ErrorResponse(ex.toString(), errors);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}