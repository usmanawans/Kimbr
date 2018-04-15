package com.kimbr.app.controller;

import com.kimbr.app.domain.User;
import com.kimbr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profile( Model model ){

        User user = userRepository.findAll().get(0);
        List<String> list = new ArrayList<>();

        for( String s : user.getAllergier().values() ){
            list.add( s );
        }

        model.addAttribute("user", user);
        model.addAttribute("list", list);


        return "profile";
    }

    @RequestMapping(value = "/profile", method= RequestMethod.POST )
    public String postProfile(@ModelAttribute("Gluten") String Gluten,
                              @ModelAttribute("Egg") String Egg,
                              @ModelAttribute("Soya") String Soya,
                              @ModelAttribute("Melk") String Melk,
                              @ModelAttribute("Peanotter") String Peanotter,
                              @ModelAttribute("Notter") String Notter,
                              @ModelAttribute("Spor") String Spor,
                              @ModelAttribute("Fisk") String Fisk,
                              @ModelAttribute("Skalldyr") String Skalldyr,
                              @ModelAttribute("Blotdyr") String Blotdyr,
                              @ModelAttribute("Sennep") String Sennep,
                              @ModelAttribute("Sesamfro") String Sesamfro,
                              @ModelAttribute("Selleri") String Selleri,
                              @ModelAttribute("Lupin") String Lupin,
                              @ModelAttribute("Svoveldioksid") String Svoveldioksid,

                              @ModelAttribute("Storfekjott") String Storfekjott,
                              @ModelAttribute("Skalldyr2") String Skalldyr2,
                              @ModelAttribute("Hvitkjott") String Hvitkjott,
                              @ModelAttribute("Fisk2") String Fisk2,
                              @ModelAttribute("Meieri") String Meieri,
                              @ModelAttribute("Egg2") String Egg2,
                              @ModelAttribute("Gelatin") String Gelatin,

                              @ModelAttribute("Kurkumin") String Kurkumin,
                              @ModelAttribute("Riboflavin") String Riboflavin,
                              @ModelAttribute("Tartrazin") String Tartrazin,
                              @ModelAttribute("Kinolingult") String Kinolingult,

                              @ModelAttribute("Nokkelhull") String Nokkelhull,
                              @ModelAttribute("NytNorge") String NytNorge,
                              @ModelAttribute("Okologisk") String Okologisk,
                              @ModelAttribute("Halal") String Halal,
                              @ModelAttribute("butikk") String butikk,

                              Model model
                              ){


        Map<String, String> allergier = new HashMap<>();

        if( !Gluten.isEmpty() )
            allergier.put( Gluten, Gluten );
        if( !Egg.isEmpty() )
            allergier.put( Egg, Egg );

        if( !Soya.isEmpty() )
            allergier.put( Soya, Soya );

        if( !Melk.isEmpty() )
            allergier.put( Melk, Melk );

        if( !Peanotter.isEmpty() )
            allergier.put( Peanotter, Peanotter );

        if( !Notter.isEmpty() )
            allergier.put( Notter, Notter );

        if( !Spor.isEmpty() )
            allergier.put( Spor, Spor );

        if( !Fisk.isEmpty() )
            allergier.put( Egg, Fisk );

        if( !Skalldyr.isEmpty() )
            allergier.put( Skalldyr, Skalldyr );

        if( !Blotdyr.isEmpty() )
            allergier.put( Blotdyr, Blotdyr );

        if( !Sennep.isEmpty() )
            allergier.put( Sennep, Sennep );

        if( !Sesamfro.isEmpty() )
            allergier.put( Sesamfro, Sesamfro );

        if( !Selleri.isEmpty() )
            allergier.put( Selleri, Selleri );

        if( !Lupin.isEmpty() )
            allergier.put( Lupin, Lupin );

        if( !Svoveldioksid.isEmpty() )
            allergier.put( Svoveldioksid, Svoveldioksid );

        if( !Storfekjott.isEmpty() )
            allergier.put( Storfekjott, Storfekjott );

        if( !Skalldyr2.isEmpty() )
            allergier.put( Skalldyr2, "Skalldyr" );

        if( !Hvitkjott.isEmpty() )
            allergier.put( Hvitkjott, Hvitkjott );

        if( !Fisk2.isEmpty() )
            allergier.put( Fisk2, "Fisk" );

        if( !Meieri.isEmpty() )
            allergier.put( Meieri, Meieri );

        if( !Egg2.isEmpty() )
            allergier.put( Egg2, "Egg" );

        if( !Gelatin.isEmpty() )
            allergier.put( Gelatin, Gelatin );

        if( !Kurkumin.isEmpty() )
            allergier.put( Kurkumin, Kurkumin );

        if( !Riboflavin.isEmpty() )
            allergier.put( Riboflavin, Riboflavin );

        if( !Tartrazin.isEmpty() )
            allergier.put( Tartrazin, Tartrazin );

        if( !Kinolingult.isEmpty() )
            allergier.put( Kinolingult, Kinolingult );

        if( !Nokkelhull.isEmpty() )
            allergier.put( Nokkelhull, Nokkelhull );

        if( !NytNorge.isEmpty() )
            allergier.put( NytNorge, NytNorge );

        if( !Okologisk.isEmpty() )
            allergier.put( Okologisk, Okologisk );

        if( !Halal.isEmpty() )
            allergier.put( Halal, Halal );


        User user = userRepository.findAll().get(0);
        user.setAllergier( allergier );
        user.setButikk( butikk );

        userRepository.save( user );

        System.out.println( butikk );

        return "redirect:/profile";
    }
}
