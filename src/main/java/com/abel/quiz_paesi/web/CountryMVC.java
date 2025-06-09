package com.abel.quiz_paesi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.abel.quiz_paesi.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CountryMVC {

    @Autowired
    private CountryService service;

    @GetMapping("countries")
    public String countries(Model m) {
        m.addAttribute("title", "Studia la geografia dei paesi");
        m.addAttribute("paesi", service.getCountries());
        return "countries";
    }

    @GetMapping("home")
    public String home(Model m) {
        m.addAttribute("title", "Benvenuto nella home");
        return "home";
    }
    
    @GetMapping("difficolta")
    public String difficolta (Model m) {
        m.addAttribute("title", "Seleziona la difficolta");
        return "difficolta";
    }

    @GetMapping("quiz")
    public String quiz (Model m) {
        m.addAttribute("title", "Seleziona il quiz che vuoi fare ");
        return "quiz";
    }

    
    @GetMapping("classifica")
    public String classifica (Model m) {
        m.addAttribute("title", "vedi la classifica ");
        return "classifica";
    }

     @GetMapping("allenamento")
    public String allenamento (Model m) {
        m.addAttribute("title", "allenati");
        return "allenamento";
    }

      @GetMapping("quiz_capitali")
    public String capitali (Model m) {
        m.addAttribute("title", "mettiti alla prova con le capitali");
        return "quiz_capitali";
    }

      @GetMapping("quiz_bandiere")
    public String bandiere (Model m) {
        m.addAttribute("title", "mettiti alla prova con le bandiere ");
        return "quiz_bandiere";
    }
    

}