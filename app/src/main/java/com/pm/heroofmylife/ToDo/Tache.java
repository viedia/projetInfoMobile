package com.pm.heroofmylife.ToDo;

/**
 * Created by Laetitia on 23/02/2018.
 */

public abstract class Tache {

    private static int ID=1;
    private int id;
    private String nom;
    private String description;
    private Difficulte diff;

    public Tache( String nom, String description, Difficulte diff) {
        this.id = ID;
        this.nom = nom;
        this.description = description;
        this.diff = diff;
        ID++;
    }

    public Tache(int id, String nom, String description, Difficulte diff) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.diff = diff;
        if(this.id >=ID){
            ID = this.id+1;
        }
    }

    @Override
    public String toString() {
        return nom ;
    }

    public Difficulte getDiff() {
        return diff;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

}
