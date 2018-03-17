package com.pm.heroofmylife.Joueur;

import android.media.Image;
import com.pm.heroofmylife.R;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Joueur {
    private String nom;
    private int level =1;
    private static int PVMAX = 100;
    private int PV = PVMAX;

    private int exp =50;
    private int expMax = 100;
    private int argent=0;
   // private String image;
    private Classe classe;
    private Caracteristique[] caracteristiques;

    public Joueur(String nom, Classe classe) {
        this.nom = nom;
        this.classe = classe;
        caracteristiques = new Caracteristique[]{new Caracteristique("Intelligence"),new Caracteristique("Force"),new Caracteristique("Agilité") };
    }


    public int GetPv() {
        return PV;
    }

    public void SetPv(int PV) {
        this.PV = PV;
        if(PV > PVMAX)
            PV = PVMAX;
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
        }
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
        if(argent < 0)
            argent = 0;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Caracteristique[] getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(Caracteristique[] caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
}
