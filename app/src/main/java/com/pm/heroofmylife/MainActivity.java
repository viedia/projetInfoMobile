package com.pm.heroofmylife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Menu m;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

    }

    public void chargerPage(View view) {
        switch (view.getId()){
            case R.id.nav_Todo:
                m.changerActivity(R.id.nav_Todo);
                break;
            case R.id.nav_Personnage:
                m.changerActivity(R.id.nav_Personnage);
                break;
            case R.id.nav_Equipement:
                m.changerActivity(R.id.nav_Equipement);
                break;
            case R.id.nav_Familier:
                m.changerActivity(R.id.nav_Familier);
                break;
        }
    }
}
