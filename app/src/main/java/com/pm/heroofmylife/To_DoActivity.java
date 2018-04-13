package com.pm.heroofmylife;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.pm.heroofmylife.BaseDeDonees.MySQLiteHelper;
import com.pm.heroofmylife.Joueur.Joueur;
import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoDeadline;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoRegulier;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

public class To_DoActivity extends FragmentActivity implements   OnItemSelectedListener  /*implements  AdapterView.OnItemSelectedListener*/ {

    private Menu m;

    private TabLayout tabLayout ;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private  ViewPagerAdapter adapter;
    private MySQLiteHelper db;




     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to__do);
        db = new MySQLiteHelper(getApplicationContext());

         m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

         adapter= new ViewPagerAdapter(getSupportFragmentManager());
        //adding Fragments
        adapter.AddFragment(new NormalTodo(), "Normal",R.drawable.plus);
         adapter.AddFragment(new RegulierTodo(), "Regulier",R.drawable.plus);
         adapter.AddFragment(new DeadlineTodo(), "Deadline",R.drawable.plus);
         setTodo();

         //adapter setup
         viewPager.setAdapter(adapter);
         tabLayout.setupWithViewPager(viewPager);


     }

     private void setTodo(){
         ArrayList<Tache> todos = db.getAllToDos("Normal");
         if(!(todos.isEmpty()))
             ((NormalTodo)adapter.getItem(0)).setListTache(todos);
         todos = db.getAllToDos("Regulier");
         if(!(todos.isEmpty()))
             ((RegulierTodo)adapter.getItem(1)).setListTache(todos);
         todos = db.getAllToDos("Deadline");
         if(!(todos.isEmpty()))
             ((DeadlineTodo)adapter.getItem(2)).setListTache(todos);
     }
    // selection d'un element du spinner, ne fonctionne pas pour l'instant

     @Override
     public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        String text = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
     }

     @Override
     public void onNothingSelected(AdapterView<?> adapterView) {

     }

    /**
     * Fonction d'ajout d'item rattacher au bouton par le layout
     * @param view
     */
    public void onAddItem(View view) {
        final Dialog dialog = new Dialog(this);
        final int fActuel = this.viewPager.getCurrentItem();
        final android.support.v4.app.Fragment fenetreActuel = adapter.getItem(fActuel);
        switch(fActuel){
            case 0:
                dialog.setContentView(R.layout.item_todonormal);
                break;
            case 1:
                dialog.setContentView(R.layout.item_todoregulier);
                break;
            case 2:
                dialog.setContentView(R.layout.item_tododeadline);
                break;
        }
        dialog.setTitle("Add new task" );
        final EditText name = (EditText) dialog.findViewById(R.id.edit_name);

        Button addButton = (Button) dialog.findViewById(R.id.task_add);

        Button closeButton = (Button) dialog.findViewById(R.id.task_delete);

        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner_competence);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.competence,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        // if button is clicked, close the custom dialog
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerToDo(dialog, fActuel, fenetreActuel);
                dialog.dismiss();
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }

     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.actionmenu, (android.view.Menu) menu);
         return true;
     }
     /**
      * Récupère les information de la fenetre d'ajout pour creer un todo
      * param  la fenetre d'ajout
      * @return le nouveau TO DO
      */
     private void creerToDo(Dialog v, int numeroFragement,  android.support.v4.app.Fragment fragement) {

         EditText name = (EditText) v.findViewById(R.id.edit_name);
         EditText description = (EditText) v.findViewById(R.id.edit_description);
         Spinner spinner = (Spinner) v.findViewById(R.id.spinner_difficulte);
         String difficulte = spinner.getSelectedItem().toString();
         spinner = (Spinner) v.findViewById(R.id.spinner_competence);
         String competence = spinner.getSelectedItem().toString();

         Tache todo = null;
         String type ="";
         switch (numeroFragement){ //cas fragement Normal
             case 0:{
                 todo = new ToDoNormal(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte));
                 ((NormalTodo)fragement).ajouterNormalTodo((ToDoNormal)todo);
                 type = "Normal";
                 break;
             }
             case 1: {//cas fragement Regulier
                 spinner = v.findViewById(R.id.spinner_frequence);
                 todo = new ToDoRegulier(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte), spinner.getSelectedItem().toString());
                 ((RegulierTodo) fragement).ajouterRegulierTodo((ToDoRegulier)todo);
                 type = "Regulier";
                 break;
             }
             case 2: { //cas fragement Deadline
                 CalendarView date = v.findViewById(R.id.simpleCalendarView);
                 todo = new ToDoDeadline(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte), date.getDate());
                 ((DeadlineTodo) fragement).ajouterDeadlineTodo((ToDoDeadline)todo);
                 type = "Deadline";
                 break;
             }
         }
         db.createToDo(todo, type);
     }

     @Override
     public void onPointerCaptureChanged(boolean hasCapture) {

     }


     public void onSelected(View view) {
        switch(view.getId()){
            case R.id.checkboxDeadLine:
                DeadlineTodo f = ((DeadlineTodo)adapter.getItem(viewPager.getCurrentItem()));
                f.validerTodo((int)view.getTag());
                db.deleteToDo(f.getId());
                break;
            case R.id.checkboxRegulier:
                 ((RegulierTodo)adapter.getItem(1)).validerTodo((int)view.getTag());
                break;
            case R.id.btnsmile:
                ((NormalTodo)adapter.getItem(0)).validerTodo((int)view.getTag());
                break;
            case R.id.btnnotsmile:
                ((NormalTodo)adapter.getItem(0)).raterTodo((int)view.getTag());
                break;
         }
     }

    @Override
    protected void onDestroy() {
         db.closeDB();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
         db.closeDB();
        super.onPause();
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
         db.closeDB();
        super.onStop();
    }
}
