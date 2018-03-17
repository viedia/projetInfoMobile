package com.pm.heroofmylife.Joueur;

/**
 * Created by Laetitia on 27/02/2018.
 */

/***
 * Classe représentant les attributs de type intelligence, force ou agilité
 */
public class Caracteristique {
    private String nom;
    private int level=1;
    private int exp = 0;
    private int expMax = 100;

    //************************COMMENT -» LevelMax ? ********************************
    // COMMENT -» Est ce qu'il faut plus d'exp plus le niveau est haut ? (niveau 1 -> 100ExpMax VS niveau 100 -> 10000ExpMax) ******************************

    public Caracteristique(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
        if(exp > expMax) //Si il a assez d'exp, le joueur passe de niveau et perd l'exp pour un niveau
        {
            level+= 1;
            exp = expMax - exp;
        }
    }

    public int getExpMax() {
        return expMax;
    }

    public void setExpMax(int expMax) {
        this.expMax = expMax;
    }
}
