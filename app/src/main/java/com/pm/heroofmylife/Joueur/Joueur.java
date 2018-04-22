package com.pm.heroofmylife.Joueur;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.pm.heroofmylife.R;
import com.pm.heroofmylife.ToDo.Tache;

import java.util.ArrayList;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Joueur {
    static Joueur instance = null;

    private int level =1;
    private static final int PVMAX = 100;
    private int pv = PVMAX;

    private int exp =50;
    private static final int EXPMAX = 100;
    private int argent=0;
    private Classe classe;
    private Caracteristique[] caracteristiques;
    private ArrayList<Competence> competences = new ArrayList<>();

    private Joueur(final Builder builder) {
        this.classe = builder.classe;
        caracteristiques = new Caracteristique[]{new Caracteristique("Force"),new Caracteristique("Intelligence"),new Caracteristique("Agilité") };
        caracteristiques[0].setLevel(builder.force);
        caracteristiques[1].setLevel(builder.intelligence);
        caracteristiques[2].setLevel(builder.agilite);

        this.level = builder.niveau;
        this.pv = builder.pv;
        this.exp = builder.exp;
        this.argent = builder.argent;
        competences.add(new Competence("DevAndroid"));
        competences.add(new Competence("Zenatitude"));
    }

    public static Joueur getInstance() {
        if (instance == null) {
            instance = new Joueur.Builder().setClasse(Classe.Guerrier).create();
            //instance.level = 666 ;
        }
        return(instance);
    }

    public static void setInstance(Joueur j){
        instance = j;
    }
    public void toDoEchec(Tache todo){
        int pertePV  =0;
        switch (todo.getDiff()){
            case 0:
                pertePV = 5;
                break;
            case 1:
                pertePV = 10;
                break;
            case 2:
                pertePV = 15;
                break;
        }
        perdrePV(pertePV);
    }

    private void perdrePV(int pertePV) {
        this.pv -=pertePV;
        if(pv == 0)
        {
            level = 1;
            exp =0;
            pv =PVMAX;
            Log.i("DICJ", "Mort");
        }
    }

    public void toDoValider(Tache todo){
        int gainXP=0;
        int gainOR = 0;
        switch (todo.getDiff()) {
            case 0:
                gainXP = 5;
                gainOR = 10;
                break;
            case 1:
                gainXP = 10;
                gainOR = 20;
                break;
            case 2:
                gainXP = 15;
                gainOR = 30;
                break;
        }
        this.ameliorerCaracteristique(todo.getCategorie());
        this.gagnerExp(gainXP);
        this.gagnerOr(gainOR);
    }

    private void ameliorerCaracteristique(int carecteristique){
        this.caracteristiques[carecteristique].gagnerLevel(1);
    }
    private void gagnerOr(int gainOR) {
        this.argent += gainOR;
    }

    private void gagnerExp(int exp) {
        this.exp += exp;
        if(this.exp >= EXPMAX) //Si il a assez d'exp, le joueur passe de niveau et perd l'exp pour un niveau
        {
            level+= 1;
            this.exp = 0;
        }
    }
    //####Getter et Setter
    public int GetPv() {
        return pv;
    }

    public void SetPv(int pv) {
        this.pv = pv;
        if(pv > PVMAX)
            this.pv = PVMAX;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
        if(argent < 0)
            this.argent = 0;
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

    public ArrayList<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(ArrayList<Competence> competences) {
        this.competences = competences;
    }

    //###BUILDER
   public static class Builder {
        private Classe classe;

        private int niveau;
        private int force;
        private int intelligence;
        private int agilite;
        private int id;
        private int pv;
        private int exp;
        private int argent;

        public Builder setPv(int pv) {
            this.pv = pv;
            return this;
        }

        public Builder setExp(int exp) {
            this.exp = exp;
            return this;
        }

        public Builder setArgent(int argent) {
            this.argent = argent;
            return this;
        }



        public Builder setClasse(final Classe c) {
            this.classe = c;
            return this;
        }

        public Builder setNiveau(int niveau) {
            this.niveau = niveau;
            return this;
        }

        public Builder setForce(int force) {
            this.force = force;
            return this;
        }

        public Builder setIntelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Builder setAgilite(int agilite) {
            this.agilite = agilite;
            return this;
        }
        public Joueur create() {
            Joueur j = new Joueur(this);
            if (j.classe.name().isEmpty()) {
                throw new IllegalStateException("Classe can not be empty!");
            }
            return j;
        }

        public Builder setId(int i) {
            this.id = i;
            return this;
        }
    }
}
