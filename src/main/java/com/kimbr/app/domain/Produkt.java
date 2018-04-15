package com.kimbr.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Produkter")
public class Produkt {

    @Id
    String _id;

    String navn;

    String bilde;

    String bildeAdresse;

    String butikk;

    List<Ingrediense> ingredienser = new ArrayList<Ingrediense>();

    public Produkt(String navn, String bilde, String butikk, List<Ingrediense> ingredienser) {
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.butikk = butikk;
        this.bilde = bilde;
        this.bildeAdresse = "/img/produkt/"+bilde+".png";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public String getBilde() {
        return bilde;
    }

    public String getButikk() {
        return butikk;
    }

    public void setButikk(String butikk) {
        this.butikk = butikk;
    }

    public void setBilde(String bilde) {
        this.bilde = bilde;
        this.bildeAdresse = "/img/produkt/"+bilde+".png";
    }

    public String getBildeAdresse() {
        return bildeAdresse;
    }

    public void setBildeAdresse(String bildeAdresse) {
        this.bildeAdresse = bildeAdresse;
    }

    @Override
    public String toString() {

        String str = "";

        for( Ingrediense i : ingredienser ){

            str += i.navn + " ";
        }

        return str;
    }
}
