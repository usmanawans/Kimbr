package com.kimbr.app.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Butikker")
public class Butikk {

    String navn;
    String ikon;
    String postNummer;
    List<Produkt> produkter = new ArrayList<Produkt>();

    public Butikk(String navn, String ikon, String postNummer, List<Produkt> produkter) {
        this.navn = navn;
        this.ikon = ikon;
        this.postNummer = postNummer;
        this.produkter = produkter;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getIkon() {
        return ikon;
    }

    public void setIkon(String ikon) {
        this.ikon = ikon;
    }

    public String getPostNummer() {
        return postNummer;
    }

    public void setPostNummer(String postNummer) {
        this.postNummer = postNummer;
    }

    public List<Produkt> getProdukter() {
        return produkter;
    }

    public void setProdukter(List<Produkt> produkter) {
        this.produkter = produkter;
    }
}
