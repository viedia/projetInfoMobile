package com.pm.heroofmylife.ToDo;

import com.pm.heroofmylife.R;

/**
 * Created by Laetitia on 23/02/2018.
 */

public abstract class Tache {

    private static int ID=1;
    private int id;
    private String nom;
    private String description;
    private int diff;
    private int categ;

    public Tache(int id, String nom, String description, int diff, int competence) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.diff = diff;
        this.categ = competence;
        if (this.id >= ID) {
            ID = this.id + 1;
        }
    }
    public Tache(String nom, String description, int diff,int competence) {
        this.id = ID;
        this.nom = nom;
        this.description = description;
        this.diff = diff;
        this.categ =competence;
        ID++;
    }

    @Override
    public String toString() {
        return nom ;
    }

    public int getDiff() {
        return diff;
    }

    public int getCategorie(){

        return categ;
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
