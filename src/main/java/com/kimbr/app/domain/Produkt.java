package com.kimbr.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Produkt {


    String navn;
    List<Ingrediense> ingredienser = new ArrayList<Ingrediense>();

    public Produkt(String navn, List<Ingrediense> ingredienser) {
        this.navn = navn;
        this.ingredienser = ingredienser;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<Ingrediense> getIngredienser() {
        return ingredienser;
    }

    public void setIngredienser(List<Ingrediense> ingredienser) {
        this.ingredienser = ingredienser;
    }
}
