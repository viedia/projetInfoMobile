package com.pm.heroofmylife;

import android.app.Dialog;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoDeadline;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoRegulier;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

 public class To_DoActivity extends AppCompatActivity implements OnItemSelectedListener  /*implements  AdapterView.OnItemSelectedListener*/ {

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

    /**
     * Fonction d'ajout d'item rattacher au bouton par le layout
     * @param view
     */
    public void onAddItem(View view) {
        //EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        //  final EditText etNewItem = new EditText(this);

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_todoNormal);
        dialog.setTitle("Add new task" );

        final EditText name = (EditText) dialog.findViewById(R.id.edit_name);

        Button addButton = (Button) dialog.findViewById(R.id.task_add);

        Button closeButton = (Button) dialog.findViewById(R.id.task_delete);

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
     /**NE FONCTIONNE PLUS TANT QUE TABS NON INSTALLE
      * Récupère les information de la fenetre d'ajout pour creer un todo
      * @param v la fenetre d'ajout
      * @return le nouveau TO DO
      */
     private Tache recupererInforamtion(Dialog v) {
    /*    Tache retour=null;
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
         return retour;*/
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
