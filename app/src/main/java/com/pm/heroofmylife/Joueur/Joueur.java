package com.pm.heroofmylife.Joueur;

import android.media.Image;
import com.pm.heroofmylife.R;

/**
 * Created by Laetitia on 27/02/2018.
 */

public class Joueur {
    private String nom;
    private int level =1;
    private int pv = PVMAX;
    private static int PVMAX = 100;
    private int exp =0;
    private int argent=0;
    private Image image;
    private Classe classe;
    private Caracteristique[] caracteristiques;

    public Joueur(String nom, Image image, Classe classe) {
        this.nom = nom;
        this.image = image;
        this.classe = classe;

        caracteristiques = new Caracteristique[]{new Caracteristique("Intelligence"),new Caracteristique("Force"),new Caracteristique("Agilité") };

    }
}
