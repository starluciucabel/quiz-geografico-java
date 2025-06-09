package com.abel.quiz_paesi.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String correctCapital;
    private String wrongCapital;

    public Question(String country, String correctCapital, String wrongCapital) {
        this.country = country;
        this.correctCapital = correctCapital;
        this.wrongCapital = wrongCapital;
    }




}


