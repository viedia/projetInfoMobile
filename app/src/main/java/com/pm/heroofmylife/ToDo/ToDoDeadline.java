package com.pm.heroofmylife.ToDo;

import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import com.pm.heroofmylife.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Laetitia on 23/02/2018.
 */

public class ToDoDeadline extends Tache {
    private long deadLine;
    public ToDoDeadline(String nom, String description, Difficulte diff, long date) {
        super(nom, description, diff);
        deadLine= date;

        Log.i("Deadline",""+deadLine);
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


    public String afficheDate() {
       // long selectedDate = CurrentCalendarView.getDate();
        long currentTime = System.currentTimeMillis();
        Log.i("GFDFDGDF",""+ currentTime);

        long temptime = deadLine-currentTime;
        Date date=new Date(temptime);
        SimpleDateFormat df2 = new SimpleDateFormat("d'jours'-MM'mois'-YYYY");
        String tempsaffiche = df2.format(date);


        return tempsaffiche;


    }



}
