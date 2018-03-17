package com.pm.heroofmylife;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.pm.heroofmylife.MainActivity;
import com.pm.heroofmylife.PersonnageActivity;
import com.pm.heroofmylife.R;
import android.app.Activity;
/**
 * Created by Laetitia on 16/03/2018.
 */

/***
 * Menu du jeu qui est un drawer
 */
public class Menu {
    private NavigationView nav_view;
    private Activity parent;

    public Menu(NavigationView menu, Activity p) {
        this.nav_view = menu;
        this.parent = p;

        this.nav_view.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem items) {
                        Menu.this.changerActivity(items.getItemId());
                        return true;
                    }
                });
    }

    /***
     * Crée une nouvelle activité en fonction de celle choisie dans le menu
     * @param nbItem ID de l'activité selectionnée par l'utilisateur
     */
    public void changerActivity(int nbItem){
        switch(nbItem){
            case R.id.nav_Todo :
            {
                Intent intent = new Intent(parent, To_DoActivity.class);
                parent.startActivity(intent);
                break;
            }
            case  R.id.nav_Personnage:
                {
                Intent intent = new Intent(parent, PersonnageActivity.class);
                parent.startActivity(intent);
                break;
            }
            case  R.id.nav_Equipement:
            {
                Intent intent = new Intent(parent, EquipementActivity.class);
                parent.startActivity(intent);
                break;
            }
            case  R.id.nav_Familier:
            {
                Intent intent = new Intent(parent, FamilierActivity.class);
                parent.startActivity(intent);
                break;
            }
        }
    }
}
