package com.pm.heroofmylife;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.util.ArrayList;

/**
 * Created by pierr on 2018-03-24.
 */

public class NormalTodo extends Fragment {
    View view;
    private TodoAdaptater itemsAdapter;
    private ArrayList<Tache> listTache;
    private ListView lvItems;


    public ListView getLvItems() {
        return lvItems;
    }


    public NormalTodo () {


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.normaltodo,container,false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvItems = (ListView) getView().findViewById(R.id.lvItems);
;

        listTache = new ArrayList<Tache>();
        listTache.add(new ToDoNormal("First Item", "Premier", Difficulte.Facile));
        listTache.add(new ToDoNormal("Second Item", "Second", Difficulte.Moyen));
        itemsAdapter = new TodoAdaptater(getActivity(), listTache);
        lvItems.setAdapter(itemsAdapter);
    }

    public void ajouterNormalTodo(ToDoNormal t){
        itemsAdapter.add(t);
    }
}
