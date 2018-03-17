package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public abstract class Tache {

    private String nom;
    private String description;
    private Difficulte diff;

    public Tache(String nom, String description, Difficulte diff) {
        this.nom = nom;
        this.description = description;
        this.diff = diff;
    }

    @Override
    public String toString() {
        return nom ;
    }

    public Difficulte getDiff() {
        return diff;
    }

}
