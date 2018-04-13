package com.pm.heroofmylife.ToDo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pm.heroofmylife.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Laetitia on 31/03/2018.
 */

public class ToDoDeadlineAdapter extends TodoAdaptater {
    public ToDoDeadlineAdapter(@NonNull Context context, ArrayList<Tache> taches, int layout) {
        super(context, taches, layout);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = super.getView(position, convertView, parent);

        // Get the data item for this position
        ToDoDeadline t = (ToDoDeadline) getItem(position);
        // Lookup view for data
        TextView champName = (TextView) convertView.findViewById(R.id.name);
        TextView champDiff = (TextView) convertView.findViewById(R.id.difficulte);
        TextView champDesc = (TextView) convertView.findViewById(R.id.description);
        TextView champcateg =(TextView) convertView.findViewById(R.id.categorie);
        TextView Afficherdate = (TextView) convertView.findViewById(R.id.tempsrestant);
        CheckBox btn = convertView.findViewById(R.id.checkboxDeadLine);

        // Populate the data into the template view using the data object
        champName.setText(t.toString());
        champDiff.setText(t.getDiff().toString());
        String Dateaffiche = t.afficheDate();
        champcateg.setText(t.getCategorie());
        champDesc.setText(t.getDescription());
        Afficherdate.setText(Dateaffiche);
        btn.setTag(position);
        btn.setChecked(false);

        return convertView;
    }
}
