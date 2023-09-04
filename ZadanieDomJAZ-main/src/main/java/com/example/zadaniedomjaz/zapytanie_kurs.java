package com.example.zadaniedomjaz;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class zapytanie_kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String waluta;


    private int liczba_dni ;

    private float kurs ;


    private LocalDateTime data_zapytania ;


    public zapytanie_kurs() {
    }

    public zapytanie_kurs(Long id, String waluta, int liczba_dni, float kurs, LocalDateTime data_zapytania) {
        this.id = id;
        this.waluta = waluta;
        this.liczba_dni = liczba_dni;
        this.kurs = kurs;
        this.data_zapytania = data_zapytania;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public int getLiczba_dni() {
        return liczba_dni;
    }

    public void setLiczba_dni(int liczba_dni) {
        this.liczba_dni = liczba_dni;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(float kurs) {
        this.kurs = kurs;
    }

    public LocalDateTime getData_zapytania() {
        return data_zapytania;
    }

    public void setData_zapytania(LocalDateTime data_zapytania) {
        this.data_zapytania = data_zapytania;
    }
}
