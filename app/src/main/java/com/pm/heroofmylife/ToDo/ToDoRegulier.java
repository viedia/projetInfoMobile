package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoRegulier extends Tache {


    private Frequence frequence;
    public ToDoRegulier(String nom, String description, Difficulte diff, String f) {
        super(nom, description, diff);
        frequence = Frequence.valueOf(f);
    }

    public Frequence getFrequence() {
        return frequence;
    }
}
