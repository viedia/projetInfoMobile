package com.pm.heroofmylife.Joueur;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.pm.heroofmylife.R;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Joueur implements Parcelable{
    private String nom;
    private int level =1;
    private static final int PVMAX = 100;
    private int pv = PVMAX;

    private int exp =50;
    private static final int EXPMAX = 100;
    private int argent=0;
    private Classe classe;
    private Caracteristique[] caracteristiques;

    public Joueur(String nom, Classe classe) {
        this.nom = nom;
        this.classe = classe;
        caracteristiques = new Caracteristique[]{new Caracteristique("Intelligence"),new Caracteristique("Force"),new Caracteristique("Agilité") };
    }

    /***
     * Lis les informations du parcel
     * @param in
     */
    protected Joueur(Parcel in) {
        nom = in.readString();
        classe = Classe.valueOf(in.readString());
        level = in.readInt();
        pv = in.readInt();
        exp = in.readInt();
        argent = in.readInt();
    }

    public static final Creator<Joueur> CREATOR = new Creator<Joueur>() {
        @Override
        public Joueur createFromParcel(Parcel in) {
            return new Joueur(in);
        }

        @Override
        public Joueur[] newArray(int size) {
            return new Joueur[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /***
     * Ecris les informations dans la parcel
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeString(classe.name());
        parcel.writeInt(level);
        parcel.writeInt(pv);
        parcel.writeInt(exp);
        parcel.writeInt(argent);
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


}
