package com.pm.heroofmylife.ToDo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pm.heroofmylife.R;

import java.util.ArrayList;

/**
 * Created by Laetitia on 31/03/2018.
 */

public class ToDoRegulierAdapter extends TodoAdaptater {
    public ToDoRegulierAdapter(@NonNull Context context, ArrayList<Tache> taches, int layout) {
        super(context, taches, layout);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, convertView, parent);

        // Get the data item for this position
        Tache t = getItem(position);
        // Lookup view for data
        TextView champName = (TextView) convertView.findViewById(R.id.name);
        TextView champDiff = (TextView) convertView.findViewById(R.id.difficulte);
        TextView champDesc = (TextView) convertView.findViewById(R.id.description);
        TextView champcateg =(TextView) convertView.findViewById(R.id.categorie);
        TextView champfreq = (TextView) convertView.findViewById(R.id.frequence);
        CheckBox btn = convertView.findViewById(R.id.checkboxRegulier);

        // Populate the data into the template view using the data object
        champName.setText(t.toString());
        champDiff.setText(t.getDiff().toString());
        champcateg.setText(t.getCategorie());
        champDesc.setText(t.getDescription());
        btn.setTag(position);
        btn.setChecked(false);

        return convertView;
    }
}
