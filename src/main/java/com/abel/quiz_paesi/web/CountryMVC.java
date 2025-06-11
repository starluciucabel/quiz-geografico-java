package com.abel.quiz_paesi.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.abel.quiz_paesi.entities.Country;
import com.abel.quiz_paesi.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryMVC {

    @Autowired
    private CountryService service;

    private Country winner;

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
    public String difficolta(Model m) {
        m.addAttribute("title", "Seleziona la difficolta");
        return "difficolta";
    }

    @GetMapping("quiz")
    public String quiz(Model m) {
        m.addAttribute("title", "Seleziona il quiz che vuoi fare ");
        return "quiz";
    }

    @GetMapping("classifica")
    public String classifica(Model m) {
        m.addAttribute("title", "vedi la classifica ");
        return "classifica";
    }

    @GetMapping("allenamento")
    public String allenamento(Model m) {
        m.addAttribute("title", "Allenati subito ");
        return "allenamento";

    }

    @PostMapping("/quizPageAnswer")
    public String postMethodName(@RequestParam String quizPageAnswer, Model m) {
        if (quizPageAnswer.equals(winner.getCapital())) {
            m.addAttribute("risultato", "Hai vinto");
        } else {
            m.addAttribute("risultato", "Hai sbagliato, la capitale è:" + winner.getCapital().toString());
        }
        m.addAttribute("paese", winner.getName());
        m.addAttribute("risposta", quizPageAnswer);
        return "training_capitali";
    }

    public Country getRandomCountry() {
        List<Country> countries = service.getCountries();
        return countries.get((int) (Math.random() * countries.size()));
    }

    public List<Country> getRandomCountries(int num) {
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            countries.add(getRandomCountry());
        }
        return countries;

    }

    @GetMapping("training_capitali")
    public String trainingCapitali(Model m) {
        List<Country> countries = this.getRandomCountries(4);
        m.addAttribute("title", "allenati");
        winner = countries.get(0);
        Collections.shuffle(countries);

        m.addAttribute("paese", winner.getName());
        m.addAttribute("paesi", countries);
        return "training_capitali";
    }

    @GetMapping("training_bandiere")
    public String trainingBandiere(Model m) {
        List<Country> countries = this.getRandomCountries(4);
        winner = countries.get(0);
        Collections.shuffle(countries);

        // Aggiunta degli attributi al model
        m.addAttribute("bandiera", winner.getFlag());
        m.addAttribute("paese", winner.getName());
        m.addAttribute("winner", winner); // facoltativo
        m.addAttribute("paesi", countries); // ❗necessario per i bottoni
        m.addAttribute("risultato", null); // per far comparire il form nel template

        return "training_bandiere";
    }

    @PostMapping("/quizBandiereAnswer")
    public String quizBandiereAnswer(@RequestParam String quizBandiereAnswer,
            @RequestParam String corretta,
            Model m) {
        if (quizBandiereAnswer.equals(corretta)) {
            m.addAttribute("risultato", "Hai indovinato la bandiera!");
        } else {
            m.addAttribute("risultato", "Risposta errata! Era: " + corretta);
        }

        m.addAttribute("paese", corretta);
        m.addAttribute("risposta", quizBandiereAnswer);
        m.addAttribute("bandiera", corretta.toLowerCase() + ".png"); // o come gestisci i file immagine

        return "training_bandiere";
    }

    @GetMapping("/quiz_capitali")
    public String quizCapitali(Model m) {
        List<Country> countries = this.getRandomCountries(4);
        winner = countries.get(0);
        Collections.shuffle(countries);

        m.addAttribute("title", "Quiz");
        m.addAttribute("paese", winner.getName());
        m.addAttribute("paesi", countries);
        return "quiz_capitali";
    }

    @PostMapping("/quizCapitaliAnswer")
    public String quizAnswer(@RequestParam String quizPageAnswer, Model m) {
        if (quizPageAnswer.equals(winner.getCapital())) {
            m.addAttribute("risultato", "Hai vinto");
        } else {
            m.addAttribute("risultato", "Hai sbagliato, la capitale è: " + winner.getCapital());
        }
        m.addAttribute("paese", winner.getName());
        m.addAttribute("risposta", quizPageAnswer);
        return "quiz_capitali";
    }

    @GetMapping("quiz_bandiere")
    public String bandiere(Model m) {
        m.addAttribute("title", "mettiti alla prova con le bandiere ");
        return "quiz_bandiere";
    }

}