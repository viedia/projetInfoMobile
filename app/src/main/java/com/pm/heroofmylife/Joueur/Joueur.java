package com.pm.heroofmylife.Joueur;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.pm.heroofmylife.R;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Joueur {
    static Joueur instance = null;

    private String nom;
    private int level =1;
    private static final int PVMAX = 100;
    private int pv = PVMAX;

    private int exp =50;
    private static final int EXPMAX = 100;
    private int argent=0;
    private Classe classe;
    private Caracteristique[] caracteristiques;

    private Joueur(final Builder builder) {
        this.nom = builder.name;
        this.classe = builder.classe;
        caracteristiques = new Caracteristique[]{new Caracteristique("Intelligence"),new Caracteristique("Force"),new Caracteristique("Agilité") };
    }

    public static Joueur getInstance() {
        if (instance == null) {
            instance = new Joueur.Builder().setName("Abruti").setClasse(Classe.Guerrier).create();
        }
        return(instance);
    }
    
    public int GetPv() {
        return pv;
    }

    public void SetPv(int pv) {
        this.pv = pv;
        if(pv > PVMAX)
            pv = PVMAX;
    }

    public int getLevel() {
        return level;
    }


    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
        if(exp > EXPMAX) //Si il a assez d'exp, le joueur passe de niveau et perd l'exp pour un niveau
        {
            level+= 1;
            exp = EXPMAX - exp;
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

    static class Builder {
        private String name;
        private Classe classe;

        public Builder setName(final String firstName) {
            this.name = firstName;
            return this;
        }

        public Builder setClasse(final Classe c) {
            this.classe = c;
            return this;
        }


        public Joueur create() {
            Joueur j = new Joueur(this);
            if (j.nom.isEmpty()) {
                throw new IllegalStateException("Name can not be empty!");
            }
            if (j.classe.name().isEmpty()) {
                throw new IllegalStateException("Classe can not be empty!");
            }
            return j;
        }
    }
}
