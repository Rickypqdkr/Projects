package com.nelricksoft.restaurante.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.nelricksoft.restaurante.restaurante.exceptions.ResourceNotFoundExceptions;

@ControllerAdvice//*1. Le dice a spring que esta clase maneja las exepciones globales */
public class GlobalExceptionHandler {
    //******** 2. Este metodo se ejecutara cada vez que se lance una ResourseNotFoundException  */
    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
        ResourceNotFoundExceptions ex, WebRequest request){
            //** 3. Crear un cuerpo de respuesta JSON limpio y ordenado*/
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.NOT_FOUND.value());
            body.put("error", "Not Found");
            body.put("message", ex.getMessage());
            body.put("path", request.getDescription(false).replace("uri=",""));

            //**** 4. Retornar el JSON con el codigo del estado de  404 Not Found */
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
    
}
