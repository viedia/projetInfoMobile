package com.pm.heroofmylife;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import com.pm.heroofmylife.Joueur.Joueur;
import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoDeadline;
import com.pm.heroofmylife.ToDo.ToDoDeadlineAdapter;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.TodoAdaptater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DeadlineFragment extends Fragment {
    View view;
    private ToDoDeadlineAdapter itemsAdapter;
    private ArrayList<Tache> listTache;
    private ListView lvItems;


    public DeadlineFragment () {
        listTache = new ArrayList<Tache>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.deadlinetodo,container,false);


        return view;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvItems = (ListView) getView().findViewById(R.id.lvItemsdeadline);
        itemsAdapter = new ToDoDeadlineAdapter(getActivity(), listTache, R.layout.temptododeadline);
        lvItems.setAdapter(itemsAdapter);
    }

    public void ajouterDeadlineTodo(ToDoDeadline toDoDeadline) {
        itemsAdapter.add(toDoDeadline);
    }

    public void validerTodo(int numTodo){
        Joueur.getInstance().toDoValider(itemsAdapter.getItem(numTodo));
        itemsAdapter.remove(itemsAdapter.getItem(numTodo));
        Log.i("DICJ", "deadline validé");
    }

    public void setListTache(ArrayList<Tache> todos){
        for (Tache t : todos){
            listTache.add(t);
        }
    }
}
