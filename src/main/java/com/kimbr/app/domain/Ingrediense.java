package com.kimbr.app.domain;


public class Ingrediense {

    String navn;
    String verdi;

    public Ingrediense(String navn, String verdi) {
        this.navn = navn;
        this.verdi = verdi;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getVerdi() {
        return verdi;
    }

    public void setVerdi(String verdi) {
        this.verdi = verdi;
    }
}
