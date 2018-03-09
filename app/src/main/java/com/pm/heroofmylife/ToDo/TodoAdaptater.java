package com.pm.heroofmylife.ToDo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pm.heroofmylife.R;

import java.util.ArrayList;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class TodoAdaptater extends ArrayAdapter<Tache> {

    public TodoAdaptater(@NonNull Context context,  ArrayList<Tache> taches ) {
        super(context, 0, taches);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Tache t = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.temptodo, parent, false);
        }
        // Lookup view for data 
        TextView champName = (TextView) convertView.findViewById(R.id.name);
        TextView champDiff = (TextView) convertView.findViewById(R.id.difficulte);
        CheckBox box = (CheckBox) convertView.findViewById(R.id.checkbox);
        // Populate the data into the template view using the data object
        champName.setText(t.toString());
        champDiff.setText(t.getDiff().toString());
        box.setTag(position);
        box.setChecked(false);
        // Return the completed view to render on screen
        return convertView;
    }
}
