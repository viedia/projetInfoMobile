package com.pm.heroofmylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;


/**
 * Created by Laetitia on 16/03/2018.
 */

public class PersonnageActivity extends Activity {
    private Menu m;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

    }
}
