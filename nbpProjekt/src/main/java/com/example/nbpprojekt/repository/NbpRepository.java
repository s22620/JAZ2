package com.example.nbpprojekt.repository;

import com.example.nbpprojekt.model.DatabaseEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Jpa<x,y>
//  x -> typ obiektu zapisanego (przełożenie tabeli na obiekt)
//  tabela(nazwa = test) :  id | value |
//  obiekt/klasa (nazwa = test) pola: id, value
// y -> typ pola id w klasie (np. int)
public interface NbpRepository extends JpaRepository<DatabaseEntry,Integer> {
}
