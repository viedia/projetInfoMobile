package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoNormal extends Tache {

    public ToDoNormal(String nom, String description, int diff, int competence) {
        super(nom, description,diff ,competence);
    }
    public ToDoNormal(int id, String nom, String description, int diff, int competence) {
        super(id, nom, description, diff, competence);
    }

}
