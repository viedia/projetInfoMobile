package com.pm.heroofmylife;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.pm.heroofmylife.BaseDeDonees.MySQLiteHelper;
import com.pm.heroofmylife.Joueur.Joueur;
import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoNormalAdapter;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

/**
 * Created by pierr on 2018-03-24.
 */

public class NormalFragment extends Fragment {
    View view;
    private ToDoNormalAdapter itemsAdapter;
    private ArrayList<Tache> listTache;
    private ListView lvItems;
    private MySQLiteHelper db;

    public ListView getLvItems() {
        return lvItems;
    }

    public NormalFragment () {
        listTache = new ArrayList<Tache>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.normaltodo,container,false);
        db = new MySQLiteHelper(getContext());
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvItems = (ListView) getView().findViewById(R.id.lvItems);
        itemsAdapter = new ToDoNormalAdapter(getActivity(), listTache, R.layout.temptodo);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();

    }

    // Attaches a long click listener to the listview
    public void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        System.out.println("LISTENEr");
                        // Remove the item within array at position
                        itemsAdapter.remove(itemsAdapter.getItem(pos));
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }
    public void ajouterNormalTodo(ToDoNormal t){
        itemsAdapter.add(t);
    }

    public void validerTodo(int tag) {
        Joueur.getInstance().toDoValider(itemsAdapter.getItem(tag));
        System.out.println(db.updateJoueur(Joueur.getInstance()));
     //   itemsAdapter.remove(itemsAdapter.getItem(tag));
        Log.i("DICJ", "normal validé");
    }


    public void raterTodo(int tag) {
        Joueur.getInstance().toDoEchec(itemsAdapter.getItem(tag));
        itemsAdapter.remove(itemsAdapter.getItem(tag));

    }

    public void setListTache(ArrayList<Tache> todos){
        for (Tache t : todos){
            listTache.add(t);
        }
    }

    public int supprimer(int tag) {
        int id = itemsAdapter.getItem(tag).getId();
        itemsAdapter.remove(itemsAdapter.getItem(tag));
        return id;
    }
}
