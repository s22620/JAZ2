package pl.pjatk.kos.jaz22051nbp.model;

public class Waluta {
    private String effectiveDate;
    private Double mid;

    public Waluta() {
    }

    public Waluta(String effectiveDate, Double mid) {
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
