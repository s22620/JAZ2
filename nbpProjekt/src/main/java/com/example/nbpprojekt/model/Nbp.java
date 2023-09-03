package com.example.nbpprojekt.model;
import java.util.List;

public class Nbp {

    private String Table;
    private String currency;
    private String code;

    private List<Rate> rates;


    public Nbp() {
    }
    public Nbp(String table, String currency, String code, List rates) {
        this.Table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String table) {
        Table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Nbp{" +
                "Table='" + Table + '\'' +
                ", currency=" + currency +
                ", code='" + code + '\'' +
                ", code='" + rates + '\'' +
                '}';
    }
}
