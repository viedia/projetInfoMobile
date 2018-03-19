package com.pm.heroofmylife;

import android.app.Dialog;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

 public class To_DoActivity extends AppCompatActivity   {

    private TodoAdaptater itemsAdapter;
    private ListView lvItems;
    private ArrayList<Tache> listTache;
    private Menu m;
    //private Spinner todotypes ;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to__do);
        m = new Menu((NavigationView) findViewById(R.id.nav_view), this);

        lvItems = (ListView) findViewById(R.id.lvItems);

        listTache = new ArrayList<Tache>();
        listTache.add(new ToDoNormal("First Item", "Premier", Difficulte.FACILE));
        listTache.add(new ToDoNormal("Second Item", "Second", Difficulte.MOYEN));
        itemsAdapter = new TodoAdaptater(this, listTache);
        lvItems.setAdapter(itemsAdapter);


        /**
         Systeme pour recupérer la valeur du spinner dans le but de cacher ou non des élements
         ne fonctionne pas pour l'instant
         */
/*
        todotypes = (Spinner) findViewById(R.id.spinner_types);
        adapter = ArrayAdapter.createFromResource(this, R.array.todotypes,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        todotypes.setAdapter(adapter);
        todotypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0 :
                        Toast toast = Toast.makeText(To_DoActivity.this, "je suis dansd le simple", Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    case 1 :
                        Toast toast2 = Toast.makeText(To_DoActivity.this, "je suis dansd le regulier", Toast.LENGTH_LONG);
                        toast2.show();
                        break;
                    case 2 :
                        Toast toast3 = Toast.makeText(To_DoActivity.this, "je suis dansd le deadline", Toast.LENGTH_LONG);
                        toast3.show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                    return;
            }
        }); */

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
        // if button is clicked, close the custom dialog
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.add(new ToDoNormal(name.getText().toString(),"", Difficulte.DIFFICILE));
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
}
