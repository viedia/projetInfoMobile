package com.pm.heroofmylife.Joueur;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Competence {
    private String nom;
    private int level =1;
    private int exp=0;
    private int expMax = 100;

    //************************COMMENT -» LevelMax ? ********************************
    // COMMENT -» Est ce qu'il faut plus d'exp plus le niveau est haut ? (niveau 1 -> 100ExpMax VS niveau 100 -> 10000ExpMax) ******************************

    public Competence(String nom) {
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
        if(exp > expMax) //Si il a assez d'exp, le joueur passe de niveau et perd l'exp pour un niveau
        {
            level+= 1;
            exp = expMax - exp;
            expMax += 50; //Augmente la quantite de exp necessaire pour le prochain niveau
        }
    }

    public int getExpMax() {
        return expMax;
    }

    public void setExpMax(int expMax) {
        this.expMax = expMax;
    }
}
