package com.abel.quiz_paesi.services;

import java.util.List;
import java.util.Random;

import com.abel.quiz_paesi.entities.Question;

public class QuestionService {

     private List<Question> questions = List.of(
        new Question("Italia", "Roma", "Madrid"),
        new Question("Francia", "Parigi", "Vienna"),
        new Question("Germania", "Berlino", "Lisbona")
    );

    public Question getRandomQuestion() {
        Random r = new Random();
        return questions.get(r.nextInt(questions.size()));
    }
    
}
