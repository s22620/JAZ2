package com.example.nbpprojekt.service;

import com.example.nbpprojekt.model.DatabaseEntry;
import com.example.nbpprojekt.model.Nbp;
import com.example.nbpprojekt.model.Rate;
import com.example.nbpprojekt.repository.NbpRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class NbpService {

    //Wstrzyknięcie customowego bean'a
    private final RestTemplate restTemplate;
    //Wstrzyknięcie Bean'a repository
    private final NbpRepository nbpRepository;
    //@Autowired
    //private NbpRepository nbpRepository;

    public NbpService(RestTemplate restTemplate, NbpRepository nbpRepository) {
        this.restTemplate = restTemplate;
        this.nbpRepository = nbpRepository;
    }

    public double getAvgCurrency(String startDate, String endDate, String currency) {
        ResponseEntity<Nbp> response = restTemplate
                .getForEntity(getUrl(startDate, endDate, currency), Nbp.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new ResponseStatusException(response.getStatusCode());
        }
        Nbp nbp = response.getBody();

        double avg = countAvgCurrency(nbp);

        DatabaseEntry databaseEntry = new DatabaseEntry();
        databaseEntry.setWalute(currency);
        databaseEntry.setWynik(avg);
        databaseEntry.setDate_start(startDate);
        databaseEntry.setDate_end(endDate);
        //LocalDate.now().getYear()
        databaseEntry.setData_zapisu(LocalDate.now().toString());
        nbpRepository.save(databaseEntry);

        return avg;
    }

    private double countAvgCurrency(Nbp nbp) {
        double sum = 0;
        for (Rate rate : nbp.getRates()) {
            sum += rate.getMid();
        }
        return sum / nbp.getRates().size();
    }
    //https://api.nbp.pl/api/exchangerates/rates/a/gbp/2012-01-01/2012-01-02/
    private String getUrl(String startDate, String endDate, String currency) {
        return "https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startDate + "/" + endDate + "/";
    }
}
