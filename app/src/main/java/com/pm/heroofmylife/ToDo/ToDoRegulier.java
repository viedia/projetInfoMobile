package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoRegulier extends Tache {


    private Frequence frequence;
    public ToDoRegulier(String nom, String description, int diff, String f, int categ) {
        super(nom, description, diff,categ);
        frequence = Frequence.valueOf(f);
    }

    public ToDoRegulier(int id, String nom, String description, int diff,String f, int categ) {
        super(id, nom, description, diff,categ);
        frequence= Frequence.valueOf(f);
    }

    public Frequence getFrequence() {
        return frequence;
    }
}
