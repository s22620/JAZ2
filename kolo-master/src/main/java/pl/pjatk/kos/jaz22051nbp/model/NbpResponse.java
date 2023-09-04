package pl.pjatk.kos.jaz22051nbp.model;

import java.util.List;

public class NbpResponse {

    private List<Waluta> rates;

    public NbpResponse(List<Waluta> rates) {
        this.rates = rates;
    }

    public NbpResponse() {
    }

    public List<Waluta> getRates() {
        return rates;
    }

    public void setRates(List<Waluta> rates) {
        this.rates = rates;
    }
}
