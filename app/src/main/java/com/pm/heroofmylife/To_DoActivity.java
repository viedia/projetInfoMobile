package com.pm.heroofmylife;

import android.app.Dialog;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TableRow;
import android.widget.Toast;

import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.PageAdapter;
import com.pm.heroofmylife.ToDo.Tab1;
import com.pm.heroofmylife.ToDo.Tab2;
import com.pm.heroofmylife.ToDo.Tab3;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoDeadline;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoRegulier;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

 public class To_DoActivity extends AppCompatActivity implements   OnItemSelectedListener  /*implements  AdapterView.OnItemSelectedListener*/ {

    private TodoAdaptater itemsAdapter;
    private ListView lvItems;
    private ArrayList<Tache> listTache;
    private Menu m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to__do);


        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

        lvItems = (ListView) findViewById(R.id.lvItems);

        listTache = new ArrayList<Tache>();
        listTache.add(new ToDoNormal("First Item", "Premier", Difficulte.Facile));
        listTache.add(new ToDoNormal("Second Item", "Second", Difficulte.Moyen));
        itemsAdapter = new TodoAdaptater(this, listTache);
        lvItems.setAdapter(itemsAdapter);



    }

    // selection d'un element du spinner, ne fonctionne pas pour l'instant

     @Override
     public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
      /*   TableRow frequence = (TableRow) view.findViewById(R.id.frequence);
         TableRow date = (TableRow) view.findViewById(R.id.date);
         TableRow notification = (TableRow) view.findViewById(R.id.notification);
         switch (position){
             case 0:
                frequence.setVisibility(View.GONE);
                 date.setVisibility(View.GONE);
                 notification.setVisibility(View.GONE);
                 break;
             case 1:
                 frequence.setVisibility(View.VISIBLE);
                 date.setVisibility(View.GONE);
                 notification.setVisibility(View.GONE);
                 break;
             case 2:
                 frequence.setVisibility(View.GONE);
                 date.setVisibility(View.VISIBLE);
                 notification.setVisibility(View.VISIBLE);
                 break;
         } */
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
        //EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        //  final EditText etNewItem = new EditText(this);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_todo);
        dialog.setTitle("Add new task" );




        final EditText name = (EditText) dialog.findViewById(R.id.edit_name);

        Button addButton = (Button) dialog.findViewById(R.id.task_add);

        Button closeButton = (Button) dialog.findViewById(R.id.task_delete);

        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner_types);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.todotypes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        // if button is clicked, close the custom dialog
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.add(recupererInforamtion(dialog));
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
      * @param v la fenetre d'ajout
      * @return le nouveau TO DO
      */
     private Tache recupererInforamtion(Dialog v) {
        Tache retour=null;
         EditText name = (EditText) v.findViewById(R.id.edit_name);
         EditText description = (EditText) v.findViewById(R.id.edit_description);
         Spinner spinner = (Spinner) v.findViewById(R.id.spinner_difficulte);
         String difficulte = spinner.getSelectedItem().toString();
         spinner = (Spinner) v.findViewById(R.id.spinner_competence);
         String competence = spinner.getSelectedItem().toString();
         spinner = (Spinner) v.findViewById(R.id.spinner_types);
         switch (spinner.getSelectedItem().toString()){
             case "Simple":
                 retour = new ToDoNormal(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte));
                 break;
             case "Regulier":
                 spinner = v.findViewById(R.id.spinner_frequence);
                 retour = new ToDoRegulier(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte), spinner.getSelectedItem().toString());
                 break;
             case "Deadline":
                 CalendarView date = v.findViewById(R.id.simpleCalendarView);
                 retour = new ToDoDeadline(name.getText().toString(), description.getText().toString(), Difficulte.valueOf(difficulte), date.getDate());
                 break;
         }
         return retour;
     }

     public void onRemove(View view) {
        // Remove the item within array at position
        listTache.remove((int)view.getTag());
        // itemsAdapter.remove(listTache.get((int)view.getTag()));
        // Refresh the adapter
        itemsAdapter.notifyDataSetChanged();
        // Return true consumes the long click event (marks it handled)
    }

    /***
     * Listener pour supprimer des fonctions
     */
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter,
                                           View item, int pos, long id) {
                // Remove the item within array at position
                listTache.remove(pos);
                // Refresh the adapter
                itemsAdapter.notifyDataSetChanged();
                // Return true consumes the long click event (marks it handled)
                return true;
            }

        });
    }


     @Override
     public void onPointerCaptureChanged(boolean hasCapture) {

     }

     
 }