package pl.pjatk.kos.jaz22051nbp.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.kos.jaz22051nbp.Repository.NbpRepository;
import pl.pjatk.kos.jaz22051nbp.model.NbpResponse;
import pl.pjatk.kos.jaz22051nbp.model.Waluta;
import pl.pjatk.kos.jaz22051nbp.model.WalutaResponse;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

@Service
public class NbpService {

    private final RestTemplate client;
    private final NbpRepository nbpRepository;

    public NbpService(NbpRepository nbpRepository, RestTemplate client) {
        this.nbpRepository = nbpRepository;
        this.client = client;
    }

    private final String url = "http://api.nbp.pl/api/exchangerates/rates/a";

    public WalutaResponse getWaluta(String waluta, Integer last) {
        LocalDate from = LocalDate.now().minusDays(last);
        LocalDate to = LocalDate.now();
        NbpResponse res = client.getForObject(url + "/{code}/{from}/{to}?format=json", NbpResponse.class, waluta, from, to);

        BigDecimal avg = BigDecimal.valueOf(res.getRates().stream().map(Waluta::getMid).mapToDouble(s -> s).average().orElseThrow())
                .round(new MathContext('3'));

        WalutaResponse response = new WalutaResponse(avg, waluta, from, to);

        nbpRepository.save(response);

        return response;
    }
}
