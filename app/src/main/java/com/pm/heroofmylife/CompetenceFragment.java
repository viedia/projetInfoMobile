package com.pm.heroofmylife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pm.heroofmylife.Joueur.Competence;
import com.pm.heroofmylife.Joueur.Joueur;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoNormalAdapter;

import java.util.ArrayList;

/**
 * Created by etudiant on 2018-04-16.
 */

public class CompetenceFragment extends android.support.v4.app.Fragment
{
   /* View view;
    private CompetencesAdapter itemsAdapter;
    private ArrayList<Competence> listCompetences;
    private ListView lvItems;


    public ListView getLvItems() {
        return lvItems;
    }


    public CompetenceFragment () {
        listCompetences = Joueur.getInstance().getCompetences();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.competence_fragment,container,false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvItems = (ListView) getView().findViewById(R.id.list_competences);
        itemsAdapter = new CompetencesAdapter(getActivity(), listCompetences, R.layout.tempcompetence);
        lvItems.setAdapter(itemsAdapter);
    }

*/

}
