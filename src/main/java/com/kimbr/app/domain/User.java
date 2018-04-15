package com.kimbr.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection="Bruker")
public class User {

    @Id
    String _id;

    String navn;

    String butikk = "KIWI";

    List<Produkt> handleliste = new ArrayList<>();

    Map<String, String> allergier = new HashMap<String, String>();

    public User() {
    }

    public User(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<Produkt> getHandleliste() {
        return handleliste;
    }

    public void setHandleliste(List<Produkt> handleliste) {
        this.handleliste = handleliste;
    }

    public Map<String, String> getAllergier() {
        return allergier;
    }

    public void setAllergier(Map<String, String> allergier) {
        this.allergier = allergier;
    }

    public void addProdukt( Produkt p ){
        this.handleliste.add(p);
    }

    public void addAllergi(String s){
        this.allergier.put(s,s);
    }

    public String getButikk() {
        return butikk;
    }

    public void setButikk(String butikk) {
        this.butikk = butikk;
    }

    public void removeProduckt(Produkt produkt) {
        handleliste.remove( produkt );
    }


}
