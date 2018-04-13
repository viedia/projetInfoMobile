package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public abstract class Tache {

    private String nom;
    private String description;
    private Difficulte diff;
    private String categ;

    public Tache(String nom, String description, Difficulte diff,String categ) {
        this.nom = nom;
        this.description = description;
        this.diff = diff;
        this.categ =categ;
    }

    @Override
    public String toString() {
        return nom ;
    }

    public Difficulte getDiff() {
        return diff;
    }
    public String getDescription() {

        return description;
    }
    public String getCategorie(){

        return categ;
    }


}
