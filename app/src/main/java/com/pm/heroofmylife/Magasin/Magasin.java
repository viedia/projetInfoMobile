package com.pm.heroofmylife.Magasin;

import com.pm.heroofmylife.Joueur.Joueur;

import java.util.ArrayList;

/**
 * Created by etudiant on 2018-03-26.
 */

public class Magasin {
    static Magasin instance = new Magasin();

    static ArrayList<Item> stock;
    static Joueur player;

    private Magasin()
    {
        Initialisation();
    }

    public static Magasin GetInstance()
    {
        return instance;
    }

    public static void Achat(Item produit)
    {
        if(player.getArgent() >= produit.getPrix() && produit.isDebloquer() == false)
        {
            produit.setDebloquer(true);
            player.setArgent(player.getArgent()- produit.getPrix());
        }
    }

    /*
    Permet de charger les differents objets provennant de la BD
     */
    private static void Initialisation(){

    }

    public ArrayList<Item> getEquipement()
    {
        ArrayList<Item> result = new ArrayList<>();

        for(int i = 0; i < stock.size(); i++)
        {
            if(stock.get(i).isEquiped())
            {
                result.add(stock.get(i));
            }
        }

        return result;
    }
}
