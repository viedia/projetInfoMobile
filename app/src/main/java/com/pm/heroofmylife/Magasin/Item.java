package com.pm.heroofmylife.Magasin;

/**
 * Created by etudiant on 2018-03-26.
 */

public class Item
{
    private int prix;
    private String nom;
    private String description;

    private boolean debloquer;
    private boolean equiped;

    Item(boolean debloq, boolean equiped)
    {
        this.debloquer = debloq;
        this.equiped = equiped;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDebloquer() {
        return debloquer;
    }

    public void setDebloquer(boolean debloquer) {
        this.debloquer = debloquer;
    }

    public boolean isEquiped() {
        return equiped;
    }

    public void setEquiped(boolean equiped) {
        this.equiped = equiped;
    }
}
