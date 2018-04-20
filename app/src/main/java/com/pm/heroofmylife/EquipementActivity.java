package com.pm.heroofmylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.ProgressBar;
import android.widget.TextView;


import com.pm.heroofmylife.Joueur.Competence;
import com.pm.heroofmylife.Joueur.Joueur;

import java.util.ArrayList;

public class EquipementActivity extends AppCompatActivity {
    private Menu m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipement);

        Intent intent = getIntent();
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);
        InitialisePage();
    }

    private void InitialisePage() {
        ProgressBar pv = (ProgressBar) findViewById(R.id.pv_progress);
        pv.setProgress(Joueur.getInstance().GetPv());

        TextView argent = (TextView) findViewById(R.id.text_argent);
        argent.setText("Argent: "+ Joueur.getInstance().getArgent());

    }


    public void Potion(View view)
    {
        Joueur player = Joueur.getInstance();

        int prixPotion = 60;
        int vieAjoute = 25;

        if(player.getArgent() > prixPotion)
        {
            Joueur.getInstance().setArgent(Joueur.getInstance().getArgent() - prixPotion);
            Joueur.getInstance().SetPv(Joueur.getInstance().GetPv() + vieAjoute);
            InitialisePage();
        }
    }
}
