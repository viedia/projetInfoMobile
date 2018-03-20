package com.pm.heroofmylife.ToDo;

import android.widget.CalendarView;

import java.util.Calendar;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoDeadline extends Tache {
    private long deadLine;
    public ToDoDeadline(String nom, String description, Difficulte diff, long date) {
        super(nom, description, diff);
        deadLine= date;
    }

    /**
     * Détermine si la date limite est passé
     * @return Vrai si c'est passée, Faux sinon
     */
    public boolean estExpire(){
        boolean res = false;
        Calendar c = Calendar.getInstance();
        if(deadLine - c.getTimeInMillis()<0){ //si l'heure actuelle est plus grande que la date limite alors...
            res = true;
        }
        return res;
    }
}
