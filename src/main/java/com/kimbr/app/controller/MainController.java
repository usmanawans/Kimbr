package com.kimbr.app.controller;


import com.kimbr.app.domain.Ingrediense;
import com.kimbr.app.domain.Produkt;
import com.kimbr.app.domain.User;
import com.kimbr.app.repository.ProduktRepository;
import com.kimbr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/")
    public String index( Model model ){

        User user = userRepository.findAll().get(0);
        String butikk = user.getButikk();

        List<Produkt> temp = new ArrayList<>();
        temp =  produktRepository.findProduktsByButikk( user.getButikk() );

        model.addAttribute("user", user);
        model.addAttribute("list", temp);

        return "index";
    }

    @RequestMapping(value = "/search", method= RequestMethod.POST )
    public String search( @ModelAttribute("q") String q,
                          Model model ){

        System.out.println( q );

        User user = userRepository.findAll().get(0);
        String butikk = user.getButikk();

        List<Produkt> temp = new ArrayList<>();
        temp =  produktRepository.findProduktsByButikk( butikk );



        model.addAttribute("q", q);
        model.addAttribute("user", user);
        model.addAttribute("list", sortEm( user.getAllergier().values(), temp, q ));

        return "search";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @RequestMapping("/alt")
    public String alt(){
        return "alt";
    }

    @RequestMapping("/cart")
    public String cart( Model model ){

        User user = userRepository.findAll().get(0);

        List<Produkt> list = user.getHandleliste();

        model.addAttribute("butikk", "Din handleliste for " + user.getButikk());
        model.addAttribute("butikkNavn", user.getButikk());
        model.addAttribute("list", list);

        return "cart";
    }



    @RequestMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable("id") String _id){

        User user = userRepository.findAll().get(0);
        String butikk = user.getButikk();

        Produkt tempProduct= null;

        List<Produkt> temp =  new ArrayList<>();

        for( Produkt p : user.getHandleliste() ){

            if( !(p.get_id().equals(_id)) )
                temp.add(p);
        }
        user.setHandleliste( temp );

        userRepository.save(user);

        return "redirect:/cart";
    }

    @RequestMapping("/addProduct/{id}")
    public String addProduct(@PathVariable("id") String id){

        User user = userRepository.findAll().get(0);
        String butikk = user.getButikk();

        user.addProdukt( produktRepository.findProduktBy_id( id ) );

        userRepository.save(user);
        return "redirect:/cart";
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
        tineHelmelkListe.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Tine Helmelk 1l", "melk1l", "KIWI", tineHelmelkListe) );


        //glutenfriMelblandingGrovListe
        List<Ingrediense> glutenfriMelblandingGrovListe = new ArrayList<Ingrediense>();
        glutenfriMelblandingGrovListe.add( new Ingrediense( "Maisstivelse", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "hvetestivelse", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "bokhvetemel", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "risbakemel", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "druesukker", "" ) );
        glutenfriMelblandingGrovListe.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Glutenfri MB Grov", "gfgrove", "KIWI", glutenfriMelblandingGrovListe) );


        //MelblandingGrovListe
        List<Ingrediense> melblandingGrovListe = new ArrayList<Ingrediense>();
        melblandingGrovListe.add( new Ingrediense( "Gluten", "" ) );
        melblandingGrovListe.add( new Ingrediense( "hvetestivelse", "" ) );
        melblandingGrovListe.add( new Ingrediense( "bokhvetemel", "" ) );
        melblandingGrovListe.add( new Ingrediense( "risbakemel", "" ) );
        melblandingGrovListe.add( new Ingrediense( "druesukker", "" ) );
        produktRepository.save( new Produkt("Glutenfri MB Grov", "grove", "KIWI", melblandingGrovListe) );


        //Pizza Grandiosa Original, 575 g
        List<Ingrediense> pizzaListe = new ArrayList<Ingrediense>();
        pizzaListe.add( new Ingrediense( "Gluten", "" ) );
        pizzaListe.add( new Ingrediense( "Storfekjøtt", "" ) );
        pizzaListe.add( new Ingrediense( "Soyabønner", "" ) );
        pizzaListe.add( new Ingrediense( "Melk", "" ) );
        produktRepository.save( new Produkt("Pizza Grandiosa 575g", "pizza", "KIWI", pizzaListe) );


        //Glutenfri Pizza Grandiosa Original, 575 g
        List<Ingrediense> glutenfripizzaListe = new ArrayList<Ingrediense>();
        pizzaListe.add( new Ingrediense( "Soyabønner", "" ) );
        pizzaListe.add( new Ingrediense( "Melk", "" ) );
        produktRepository.save( new Produkt("Glutenfri Pizza 575g", "gfpizza", "KIWI", pizzaListe) );


        // Produkter til REMA1000


        // Tine Helmelk 1l
        List<Ingrediense> tineHelmelkListeREMA1000 = new ArrayList<Ingrediense>();
        tineHelmelkListeREMA1000.add( new Ingrediense( "Energi", "264 kJ / 63 kcal" ) );
        tineHelmelkListeREMA1000.add( new Ingrediense( "Fett", "3,50 g" ) );
        tineHelmelkListeREMA1000.add( new Ingrediense( "Protein", "4,50 g" ) );
        tineHelmelkListeREMA1000.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Tine Helmelk 1l", "melk1l", "REMA1000", tineHelmelkListeREMA1000) );


        //glutenfriMelblandingGrovListe
        List<Ingrediense> glutenfriMelblandingGrovListeREMA1000 = new ArrayList<Ingrediense>();
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "Maisstivelse", "" ) );
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "hvetestivelse", "" ) );
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "bokhvetemel", "" ) );
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "risbakemel", "" ) );
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "druesukker", "" ) );
        glutenfriMelblandingGrovListeREMA1000.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Glutenfri MB Grov", "gfgrove", "KIWI", glutenfriMelblandingGrovListeREMA1000) );


        //MelblandingGrovListe
        List<Ingrediense> melblandingGrovListeREMA1000 = new ArrayList<Ingrediense>();
        melblandingGrovListeREMA1000.add( new Ingrediense( "Gluten", "" ) );
        melblandingGrovListeREMA1000.add( new Ingrediense( "hvetestivelse", "" ) );
        melblandingGrovListeREMA1000.add( new Ingrediense( "bokhvetemel", "" ) );
        melblandingGrovListeREMA1000.add( new Ingrediense( "risbakemel", "" ) );
        melblandingGrovListeREMA1000.add( new Ingrediense( "druesukker", "" ) );
        produktRepository.save( new Produkt("Glutenfri MB Grov", "grove", "REMA1000", melblandingGrovListeREMA1000) );


        //Pizza Grandiosa Original, 575 g
        List<Ingrediense> pizzaListeREMA1000 = new ArrayList<Ingrediense>();
        pizzaListeREMA1000.add( new Ingrediense( "Gluten", "" ) );
        pizzaListeREMA1000.add( new Ingrediense( "Soyabønner", "" ) );
        pizzaListeREMA1000.add( new Ingrediense( "Melk", "" ) );
        produktRepository.save( new Produkt("Pizza Grandiosa 575g", "pizza", "REMA1000", pizzaListeREMA1000) );


        //Glutenfri Pizza Grandiosa Original, 575 g
        List<Ingrediense> glutenfripizzaListeREMA1000 = new ArrayList<Ingrediense>();
        glutenfripizzaListeREMA1000.add( new Ingrediense( "Soyabønner", "" ) );
        glutenfripizzaListeREMA1000.add( new Ingrediense( "Melk", "" ) );
        produktRepository.save( new Produkt("Glutenfri Pizza 575g", "gfpizza", "REMA1000", glutenfripizzaListeREMA1000) );


        // new for rema1000

        //Makrell i tomat 170g, 575 g
        List<Ingrediense> makrellREMA1000 = new ArrayList<Ingrediense>();
        makrellREMA1000.add( new Ingrediense( "Fisk", "" ) );
        makrellREMA1000.add( new Ingrediense( "Makrellfilet", "" ) );
        makrellREMA1000.add( new Ingrediense( "tomatsaus", "" ) );
        makrellREMA1000.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Makrell i tomat 170g", "makrellfilet", "REMA1000", makrellREMA1000) );


        //Kjøttpudding 500 g
        List<Ingrediense> kjottpudding1000 = new ArrayList<Ingrediense>();
        kjottpudding1000.add( new Ingrediense( "Kjott", "" ) );
        kjottpudding1000.add( new Ingrediense( "Storfekjøtt", "" ) );
        kjottpudding1000.add( new Ingrediense( "gelatin", "" ) );
        produktRepository.save( new Produkt("Kjøttpudding 500g", "kjottpudding", "REMA1000", kjottpudding1000) );


        //Piano Sjokoladepudding
        List<Ingrediense> sjokoladepudding1000 = new ArrayList<Ingrediense>();
        sjokoladepudding1000.add( new Ingrediense( "Melk", "" ) );
        sjokoladepudding1000.add( new Ingrediense( "Sukker", "" ) );
        sjokoladepudding1000.add( new Ingrediense( "Aroma", "" ) );
        sjokoladepudding1000.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Piano Sjokoladepudding", "sjokoladepudding", "REMA1000", sjokoladepudding1000) );

        //Fiskepudding Snabb 340g
        List<Ingrediense> fiskepudding1000 = new ArrayList<Ingrediense>();
        fiskepudding1000.add( new Ingrediense( "Fisk", "" ) );
        fiskepudding1000.add( new Ingrediense( "Hvitlaks", "" ) );
        fiskepudding1000.add( new Ingrediense( "Melk", "" ) );
        fiskepudding1000.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Fiskepudding Snabb 340g", "fiskepudding", "REMA1000", fiskepudding1000) );


        //Makrell i tomat 170g, 575 g
        List<Ingrediense> makrellKIWI = new ArrayList<Ingrediense>();
        makrellKIWI.add( new Ingrediense( "Fisk", "" ) );
        makrellKIWI.add( new Ingrediense( "Makrellfilet", "" ) );
        makrellKIWI.add( new Ingrediense( "tomatsaus", "" ) );
        makrellKIWI.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Makrell i tomat 170g", "makrellfilet", "KIWI", makrellKIWI) );


        //Kjøttpudding 500 g
        List<Ingrediense> kjottpuddingKIWI = new ArrayList<Ingrediense>();
        kjottpuddingKIWI.add( new Ingrediense( "Kjott", "" ) );
        kjottpuddingKIWI.add( new Ingrediense( "Storfekjøtt", "" ) );
        kjottpuddingKIWI.add( new Ingrediense( "gelatin", "" ) );
        produktRepository.save( new Produkt("Kjøttpudding 500g", "kjottpudding", "KIWI", kjottpuddingKIWI) );


        //Piano Sjokoladepudding
        List<Ingrediense> sjokoladepuddingKIWI = new ArrayList<Ingrediense>();
        sjokoladepuddingKIWI.add( new Ingrediense( "Melk", "" ) );
        sjokoladepuddingKIWI.add( new Ingrediense( "Sukker", "" ) );
        sjokoladepuddingKIWI.add( new Ingrediense( "Aroma", "" ) );
        sjokoladepuddingKIWI.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Piano Sjokoladepudding", "sjokoladepudding", "KIWI", sjokoladepuddingKIWI) );

        //Piano Sjokoladepudding
        List<Ingrediense> fiskepuddingKIWI = new ArrayList<Ingrediense>();
        fiskepuddingKIWI.add( new Ingrediense( "Fisk", "" ) );
        fiskepuddingKIWI.add( new Ingrediense( "Hvitlaks", "" ) );
        fiskepuddingKIWI.add( new Ingrediense( "Melk", "" ) );
        fiskepuddingKIWI.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Fiskepudding Snabb 340g", "fiskepudding", "KIWI", fiskepuddingKIWI) );


        //Oreo Rull Kjeks
        List<Ingrediense> orioKIWI = new ArrayList<Ingrediense>();
        orioKIWI.add( new Ingrediense( "Palm", "" ) );
        orioKIWI.add( new Ingrediense( "Hvitlaks", "" ) );
        orioKIWI.add( new Ingrediense( "Melk", "" ) );
        orioKIWI.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Oreo Rull Kjeks 157g", "orio", "KIWI", orioKIWI) );



        //Safari Kjeks
        List<Ingrediense> safariKIWI = new ArrayList<Ingrediense>();
        safariKIWI.add( new Ingrediense( "Notter", "" ) );
        safariKIWI.add( new Ingrediense( "Gluten", "" ) );
        safariKIWI.add( new Ingrediense( "Melk", "" ) );
        safariKIWI.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Safari Kjeks 200g", "safari", "KIWI", safariKIWI) );


        //Oreo Rull Kjeks
        List<Ingrediense> orioREMA = new ArrayList<Ingrediense>();
        orioREMA.add( new Ingrediense( "Palm", "" ) );
        orioREMA.add( new Ingrediense( "Hvitlaks", "" ) );
        orioREMA.add( new Ingrediense( "Melk", "" ) );
        orioREMA.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Oreo Rull Kjeks 157g", "orio", "REMA1000", orioREMA) );



        //Safari Kjeks
        List<Ingrediense> safariREMA = new ArrayList<Ingrediense>();
        safariREMA.add( new Ingrediense( "Notter", "" ) );
        safariREMA.add( new Ingrediense( "Gluten", "" ) );
        safariREMA.add( new Ingrediense( "Melk", "" ) );
        safariREMA.add( new Ingrediense( "Hilal", "" ) );
        produktRepository.save( new Produkt("Safari Kjeks 200g", "safari", "REMA1000", safariREMA) );


        return "redirect:/";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        userRepository.save( new User("Usman") );

        return "redirect:/";
    }


    List<Produkt> sortEm(Collection<String> allergies, List<Produkt> products, String q ){

        List<Produkt> searched = new ArrayList<>();
        List<Produkt> sorted = new ArrayList<>();

        for( String str : allergies ){
            for( Produkt p : products ){

                if( p.getNavn().toLowerCase().contains( q.toLowerCase() ) ){
                    if( !searched.contains(p) )
                        searched.add(p);
                }
            }
        }

        List<Produkt> searched2 = new ArrayList<>();

        for( Produkt p : searched ){
            searched2.add(p);
        }


        for( String str : allergies ){
            for( Produkt p : searched ){
                for( Ingrediense i : p.getIngredienser() ){

                    if( (i.getNavn().toLowerCase().contains( str.toLowerCase() )) )
                        searched2.remove(p);
                }
            }
        }



        return searched2;
    }
}
