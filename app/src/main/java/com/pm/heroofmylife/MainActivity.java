package com.pm.heroofmylife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private TodoAdaptater itemsAdapter;
    private ListView lvItems;
    private ArrayList<Tache> listTache;

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
      /*  for(Tache t : listTache){
           // items.add(t.toString());
            itemsAdapter.add(t);
        }*/

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
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        listTache.add(new ToDoNormal(etNewItem.getText().toString(),"",Difficulte.DIFFICILE));
        etNewItem.setText("");
    }
}
