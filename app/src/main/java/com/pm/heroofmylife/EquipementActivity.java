package com.pm.heroofmylife;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.pm.heroofmylife.Joueur.Joueur;

public class EquipementActivity extends AppCompatActivity {
    private Menu m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipement);

        Intent intent = getIntent();
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

    }

}
