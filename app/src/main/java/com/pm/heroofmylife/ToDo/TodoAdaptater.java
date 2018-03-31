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

    private int layout;
    public TodoAdaptater(@NonNull Context context,  ArrayList<Tache> taches, int layout ) {
        super(context, 0, taches);
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }


        // Return the completed view to render on screen
        return convertView;
    }
}
