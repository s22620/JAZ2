package com.example.nbpprojekt.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    //? 1.Dostajemy odpowiedz z NBP - serwer = ClientHttpResponse response
    //  2. Rzucamy inny wyjątek - nasz zdefiniowany (Tak to nazwijmy) który ma taki sam status jak ten z NBP
    //  3. ErrorHandler oczekuje na nasz zdefiniowany wyjątek
    // NbpError -> NaszNbpError
    // ErrorHandler oczekuje na NaszNbpError
    // NaszNbpError.statusCode = NbpError.statusCode
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new ResponseStatusException(response.getStatusCode());
    }


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !response.getStatusCode().equals(HttpStatus.OK);
    }
}
