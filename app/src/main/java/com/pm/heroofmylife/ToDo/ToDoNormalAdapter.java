package com.pm.heroofmylife.ToDo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.pm.heroofmylife.R;

import java.util.ArrayList;

/**
 * Created by Laetitia on 31/03/2018.
 */

public class ToDoNormalAdapter extends TodoAdaptater {
    public ToDoNormalAdapter(@NonNull Context context, ArrayList<Tache> taches, int layout) {
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
        ImageButton smile = convertView.findViewById(R.id.btnsmile);
        ImageButton notSmile = convertView.findViewById(R.id.btnnotsmile);
        ImageButton suppr = convertView.findViewById(R.id.btnSuppressionNormal);



        // Populate the data into the template view using the data object
        champName.setText(t.toString());
        champDiff.setText(intToDifficulte(t.getDiff()));
        champDesc.setText(t.getDescription());
        champcateg.setText(intToCaracteristique(t.getCategorie()));
        smile.setTag(position);
        notSmile.setTag(position);
        suppr.setTag(position);

        return convertView;
    }


}
