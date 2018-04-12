package com.kimbr.app.controller;


import com.kimbr.app.domain.Butikk;
import com.kimbr.app.domain.Ingrediense;
import com.kimbr.app.domain.Produkt;
import com.kimbr.app.repository.ButikkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ButikkRepository butikkRepository;

    @RequestMapping("/")
    public String index( Model model ){
        return "index";
    }

    @RequestMapping("/alt")
    public String alt(){
        return "alt";
    }

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/addTestData")
    public String test(){

        // Tine Helmelk 1l
        List<Ingrediense> tineHelmelkListe = new ArrayList<Ingrediense>();
        tineHelmelkListe.add( new Ingrediense( "Energi", "264 kJ / 63 kcal" ) );
        tineHelmelkListe.add( new Ingrediense( "Fett", "3,50 g" ) );
        tineHelmelkListe.add( new Ingrediense( "Protein", "4,50 g" ) );
        tineHelmelkListe.add( new Ingrediense( "Protein", "3,40 g" ) );
        tineHelmelkListe.add( new Ingrediense( "Salt", "0,10 g" ) );
        Produkt tineHelmelk = new Produkt("Tine Helmelk 1l", tineHelmelkListe);

        //glutenfriMelblandingGrovListe
        List<Ingrediense> glutenfriMelblandingGrovListe = new ArrayList<Ingrediense>();
        glutenfriMelblandingGrovListe.add( new Ingrediense( "Maisstivelse", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "hvetestivelse", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "bokhvetemel", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "risbakemel", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "druesukker", "" ) );
        Produkt glutenfriMelblandingGrov = new Produkt("Glutenfri Melblanding Grov", glutenfriMelblandingGrovListe);


        //MelblandingGrovListe
        List<Ingrediense> melblandingGrovListe = new ArrayList<Ingrediense>();
        melblandingGrovListe.add( new Ingrediense( "Gluten", "" ) );
        melblandingGrovListe.add( new Ingrediense( "hvetestivelse", "" ) );
        melblandingGrovListe.add( new Ingrediense( "bokhvetemel", "" ) );
        melblandingGrovListe.add( new Ingrediense( "risbakemel", "" ) );
        melblandingGrovListe.add( new Ingrediense( "druesukker", "" ) );
        Produkt melblandingGrov = new Produkt("Melblanding Grov", melblandingGrovListe);


        //Pizza Grandiosa Original, 575 g
        List<Ingrediense> pizzaListe = new ArrayList<Ingrediense>();
        pizzaListe.add( new Ingrediense( "Gluten", "" ) );
        pizzaListe.add( new Ingrediense( "Soyabønner", "" ) );
        pizzaListe.add( new Ingrediense( "Melk", "" ) );
        Produkt pizza = new Produkt("Pizza Grandiosa 575g", pizzaListe);


        //Glutenfri Pizza Grandiosa Original, 575 g
        List<Ingrediense> glutenfripizzaListe = new ArrayList<Ingrediense>();
        pizzaListe.add( new Ingrediense( "Soyabønner", "" ) );
        pizzaListe.add( new Ingrediense( "Melk", "" ) );
        Produkt glutenfripizza = new Produkt("Glutenfri Pizza Grandiosa 575g", pizzaListe);

        List<Produkt> produkterTilKiwi = new ArrayList<Produkt>();
        produkterTilKiwi.add( tineHelmelk );
        produkterTilKiwi.add( glutenfriMelblandingGrov );
        produkterTilKiwi.add( melblandingGrov );
        produkterTilKiwi.add( pizza );
        produkterTilKiwi.add( glutenfripizza );

        List<Produkt> produkterTilRema = new ArrayList<Produkt>();
        produkterTilRema.add( tineHelmelk );
        produkterTilRema.add( glutenfriMelblandingGrov );
        produkterTilRema.add( melblandingGrov );
        produkterTilRema.add( pizza );
        produkterTilRema.add( glutenfripizza );




        Butikk kiwi = new Butikk( "Kiwi", "icon", "0864", produkterTilKiwi);
        Butikk rema = new Butikk( "Rema", "icon", "0864", produkterTilRema);

        butikkRepository.save( kiwi );
        butikkRepository.save( rema );

        return "redirect:/";
    }
}
