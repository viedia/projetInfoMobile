package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoNormal extends Tache {

    public ToDoNormal(String nom, String description, Difficulte diff) {
        super(nom, description, diff);
    }
    public ToDoNormal(int id, String nom, String description, Difficulte diff) {
        super(id, nom, description, diff);
    }

}
