package com.pm.heroofmylife;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.pm.heroofmylife.Joueur.Classe;
import com.pm.heroofmylife.Joueur.Joueur;

public class MainActivity extends AppCompatActivity {
    private Menu m;
    private Joueur j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);
        j = new Joueur("Toto", Classe.Voleur);

    }

    public void chargerPage(View view) {
        switch (view.getId()){
            case R.id.nav_Todo:
                m.changerActivity(R.id.nav_Todo, null);
                break;
            case R.id.nav_Personnage:
                m.changerActivity(R.id.nav_Personnage, j);
                break;
            case R.id.nav_Equipement:
                m.changerActivity(R.id.nav_Equipement, null);
                break;
            case R.id.nav_Familier:
                m.changerActivity(R.id.nav_Familier, null);
                break;
        }
    }
}
