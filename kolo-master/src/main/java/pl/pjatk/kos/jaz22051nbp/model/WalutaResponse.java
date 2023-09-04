package pl.pjatk.kos.jaz22051nbp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "walutaresponse")
public class WalutaResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "average")
    private BigDecimal avg;
    private String currency;
    private LocalDate fromDate;
    private LocalDate toDate;
    @Column(name = "createdAt")
    private LocalDateTime create = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public WalutaResponse() {
    }

    public WalutaResponse(BigDecimal avg, String currency, LocalDate fromDate, LocalDate toDate) {
        this.avg = avg;
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public WalutaResponse(Long id, BigDecimal avg, String currency, LocalDate fromDate, LocalDate toDate, LocalDateTime create) {
        this.id = id;
        this.avg = avg;
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.create = create;
    }

    public WalutaResponse(BigDecimal avg, String currency, LocalDate fromDate, LocalDate toDate, LocalDateTime create) {
        this.avg = avg;
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.create = create;
    }
}
