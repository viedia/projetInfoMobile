package com.pm.heroofmylife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pm.heroofmylife.Joueur.Competence;
import com.pm.heroofmylife.ToDo.Tache;

import java.util.ArrayList;

/**
 * Created by etudiant on 2018-04-16.
 */

public class CompetencesAdapter extends ArrayAdapter<Competence>
{
    private int layout;
    public CompetencesAdapter(@NonNull Context context, ArrayList<Competence> competences, int layout) {
        super(context, 0, competences);
        this.layout = layout;

    }

    @NonNull
    public View getView(int position, View convertView, ViewGroup parent) {
       // convertView = super.getView(position, convertView, parent);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }
        // Get the data item for this position
        Competence t = getItem(position);

        // Lookup view for data
        TextView champName = (TextView) convertView.findViewById(R.id.name_competence);
        TextView champLevel = (TextView) convertView.findViewById(R.id.lvl_competence);


        // Populate the data into the template view using the data object
        champName.setText(t.getNom());
        champLevel.setText(String.valueOf(t.getLevel()));

        return convertView;
    }
}
