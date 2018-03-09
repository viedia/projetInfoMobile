package com.pm.heroofmylife;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private ArrayList<String> items;
    private TodoAdaptater itemsAdapter;
    private ListView lvItems;
    private ArrayList<Tache> listTache;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);

        listTache = new ArrayList<Tache>();
        listTache.add(new ToDoNormal("First Item", "Premier", Difficulte.FACILE));
        listTache.add(new ToDoNormal("Second Item", "Second", Difficulte.MOYEN));

        itemsAdapter = new TodoAdaptater(this, listTache);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    /***
     * Listener pour supprimer des foncitons
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
                itemsAdapter.add(new ToDoNormal(name.getText().toString(),"",Difficulte.DIFFICILE));
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
}
