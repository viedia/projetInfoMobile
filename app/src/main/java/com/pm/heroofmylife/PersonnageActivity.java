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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnage);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()  == R.id.nav_Todo)
                {
                    Intent intent = new Intent(PersonnageActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                if(item.getItemId() == R.id.nav_other)
                {
                    Intent intent = new Intent(PersonnageActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}
