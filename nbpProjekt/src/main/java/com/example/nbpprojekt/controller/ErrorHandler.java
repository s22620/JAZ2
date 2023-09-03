package com.example.nbpprojekt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.net.ConnectException;


//Może byc sama klasa
@RestControllerAdvice
public class ErrorHandler {
    //wyjątek jaki ma zostac zlapany
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> responseStatusExHandler(ResponseStatusException ex) {
        HttpStatusCode statusCode = ex.getStatusCode();
        if (HttpStatus.NOT_FOUND.equals(statusCode)) {
            // to samo : ResponseEntity.notFound();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - Not Found upsi daisy");
        } else if (HttpStatus.BAD_REQUEST.equals(statusCode)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 Bad Request KURZA TWARZ");
        }
        return ResponseEntity.status(statusCode).body(ex.getMessage());
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<String> connectExHandler(ResponseStatusException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Internal Server Error - niestety");
    }
}
