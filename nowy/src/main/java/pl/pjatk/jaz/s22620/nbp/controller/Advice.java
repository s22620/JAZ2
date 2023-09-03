package pl.pjatk.jaz.s22620.nbp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class Advice {
    @ExceptionHandler (ResponseStatusException.class)
    public ResponseEntity<String> responseStatusExHandler (ResponseStatusException ex){
        HttpStatusCode statusCode = ex.getStatusCode();
        if (HttpStatus.NOT_FOUND.equals(statusCode)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404 - Nie ma takiego numeru");
        } else if (HttpStatus.BAD_REQUEST.equals(statusCode)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("400 - coś poszło nie tak");
        }
        return ResponseEntity.status(statusCode).body(ex.getMessage());
    }

}
