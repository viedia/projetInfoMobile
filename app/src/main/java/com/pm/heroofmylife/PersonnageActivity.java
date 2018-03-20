package com.pm.heroofmylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pm.heroofmylife.Joueur.Joueur;


/**
 * Created by Laetitia on 16/03/2018.
 */

public class PersonnageActivity extends Activity {
    private Menu m;
    private Joueur j;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        Intent intent = getIntent();
        j = (Joueur) intent.getParcelableExtra("joueur");
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

        initialiserPage();
    }

    /***
     * Initialise la page avec les informations du joueur
     */
    private void initialiserPage() {
        ImageView image = (ImageView) findViewById(R.id.image_personnage);
        image.setImageResource(getImage());

        TextView classe = (TextView) findViewById(R.id.class_personnage);
        classe.setText(j.getClasse().toString());
        TextView niveau = (TextView) findViewById(R.id.niveau_personnage);
        niveau.setText(niveau.getText()+" "+String.valueOf(j.getLevel()));
        ProgressBar exp = (ProgressBar) findViewById(R.id.exp_progress);
        exp.setProgress(j.getExp());
    }

    /**
     * retourne l'image correspondant à la classe du personnage
     * @return ID de l'image
     */
    private int getImage(){
        int ressource = -1;
        switch (j.getClasse()){
                case Mage:
                    ressource = R.drawable.voleur;
                    break;
                case Guerrier:
                    ressource = R.drawable.voleur;
                    break;
                case Voleur:
                    ressource = R.drawable.voleur;
                    break;

        }
        return ressource;
    }
}
