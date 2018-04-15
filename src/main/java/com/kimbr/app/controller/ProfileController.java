package com.kimbr.app.controller;

import com.kimbr.app.domain.User;
import com.kimbr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String profile( Model model ){

        User user = userRepository.findAll().get(0);

        model.addAttribute("user", user);
        model.addAttribute("list", user.getAllergier().values());


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
        else if( !Egg.isEmpty() )
            allergier.put( Egg, Egg );

        else if( !Soya.isEmpty() )
            allergier.put( Soya, Soya );

        else if( !Melk.isEmpty() )
            allergier.put( Melk, Melk );

        else if( !Peanotter.isEmpty() )
            allergier.put( Peanotter, Peanotter );

        else if( !Notter.isEmpty() )
            allergier.put( Notter, Notter );

        else if( !Spor.isEmpty() )
            allergier.put( Spor, Spor );

        else if( !Fisk.isEmpty() )
            allergier.put( Egg, Fisk );

        else if( !Skalldyr.isEmpty() )
            allergier.put( Skalldyr, Skalldyr );

        else if( !Blotdyr.isEmpty() )
            allergier.put( Blotdyr, Blotdyr );

        else if( !Sennep.isEmpty() )
            allergier.put( Sennep, Sennep );

        else if( !Sesamfro.isEmpty() )
            allergier.put( Sesamfro, Sesamfro );

        else if( !Selleri.isEmpty() )
            allergier.put( Selleri, Selleri );

        else if( !Lupin.isEmpty() )
            allergier.put( Lupin, Lupin );

        else if( !Svoveldioksid.isEmpty() )
            allergier.put( Svoveldioksid, Svoveldioksid );

        else if( !Storfekjott.isEmpty() )
            allergier.put( Storfekjott, Storfekjott );

        else if( !Skalldyr2.isEmpty() )
            allergier.put( Skalldyr2, "Skalldyr" );

        else if( !Hvitkjott.isEmpty() )
            allergier.put( Hvitkjott, Hvitkjott );

        else if( !Fisk2.isEmpty() )
            allergier.put( Fisk2, "Fisk" );

        else if( !Meieri.isEmpty() )
            allergier.put( Meieri, Meieri );

        else if( !Egg2.isEmpty() )
            allergier.put( Egg2, "Egg" );

        else if( !Gelatin.isEmpty() )
            allergier.put( Gelatin, Gelatin );

        else if( !Kurkumin.isEmpty() )
            allergier.put( Kurkumin, Kurkumin );

        else if( !Riboflavin.isEmpty() )
            allergier.put( Riboflavin, Riboflavin );

        else if( !Tartrazin.isEmpty() )
            allergier.put( Tartrazin, Tartrazin );

        else if( !Kinolingult.isEmpty() )
            allergier.put( Kinolingult, Kinolingult );

        else if( !Nokkelhull.isEmpty() )
            allergier.put( Nokkelhull, Nokkelhull );

        else if( !NytNorge.isEmpty() )
            allergier.put( NytNorge, NytNorge );

        else if( !Okologisk.isEmpty() )
            allergier.put( Okologisk, Okologisk );

        else if( !Halal.isEmpty() )
            allergier.put( Halal, Halal );


        User user = userRepository.findAll().get(0);
        user.setAllergier( allergier );
        user.setButikk( butikk );

        userRepository.save( user );

        System.out.println( butikk );

        return "redirect:/profile";
    }
}
