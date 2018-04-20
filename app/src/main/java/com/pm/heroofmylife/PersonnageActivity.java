package com.pm.heroofmylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pm.heroofmylife.BaseDeDonees.MySQLiteHelper;
import com.pm.heroofmylife.Joueur.Classe;
import com.pm.heroofmylife.Joueur.Competence;
import com.pm.heroofmylife.Joueur.Joueur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * Created by Laetitia on 16/03/2018.
 */

public class PersonnageActivity extends FragmentActivity {
    private Menu m;
   private MySQLiteHelper db;
    private CompetencesAdapter itemsAdapter;
    private ArrayList<Competence> listCompetences;
    private ListView lvItems;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        Intent intent = getIntent();
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);
        db= new MySQLiteHelper(getApplicationContext());
        initialiserPage();
    }

    /***
     * Initialise la page avec les informations du joueur
     */
    private void initialiserPage() {
        Joueur j = Joueur.getInstance();

        ImageView image = (ImageView) findViewById(R.id.image_personnage);
        image.setImageResource(getImage(j.getClasse()));

        TextView classe = (TextView) findViewById(R.id.class_personnage);
        classe.setText(j.getClasse().toString());

        TextView niveau = (TextView) findViewById(R.id.niveau_personnage);
        String text = niveau.getText() +" "+ Integer.toString(j.getLevel());
        niveau.setText(text);

        ProgressBar exp = (ProgressBar) findViewById(R.id.exp_progress);
        exp.setProgress(j.getExp());

        TextView argent = (TextView) findViewById(R.id.text_argent);
        argent.setText(argent.getText() +" "+ Joueur.getInstance().getArgent());

        lvItems = (ListView) this.findViewById(R.id.list_competences);
        itemsAdapter = new CompetencesAdapter(this, Joueur.getInstance().getCompetences(), R.layout.tempcompetence);
        lvItems.setAdapter(itemsAdapter);

        }

    /**
     * retourne l'image correspondant à la classe du personnage
     * @return ID de l'image
     */
    private int getImage(Classe c){
        int ressource = -1;
        switch (c){
                case Mage:
                    ressource = R.drawable.mage;
                    break;
                case Guerrier:
                    ressource = R.drawable.guerrier;
                    break;
                case Voleur:
                    ressource = R.drawable.voleur;
                    break;
        }
        return ressource;
    }
    @Override
    protected void onDestroy() {
        db.updateJoueur(Joueur.getInstance());
        db.closeDB();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        System.out.println(db.updateJoueur(Joueur.getInstance()));
        db.closeDB();
        super.onPause();
    }

    public void chargerPage(View view) {
        m.changerActivity(view.getId());
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        db.updateJoueur(Joueur.getInstance());
        db.closeDB();
        super.onStop();
    }
}
