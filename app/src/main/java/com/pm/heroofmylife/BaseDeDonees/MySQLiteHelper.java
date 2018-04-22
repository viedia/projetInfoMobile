package com.pm.heroofmylife.BaseDeDonees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.pm.heroofmylife.DeadlineFragment;
import com.pm.heroofmylife.Joueur.Classe;
import com.pm.heroofmylife.Joueur.Joueur;
import com.pm.heroofmylife.ToDo.Difficulte;
import com.pm.heroofmylife.ToDo.Tache;
import com.pm.heroofmylife.ToDo.ToDoDeadline;
import com.pm.heroofmylife.ToDo.ToDoNormal;
import com.pm.heroofmylife.ToDo.ToDoRegulier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laetitia on 10/04/2018.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    //table TODO
    public static final String TABLE_TODO = "Todo";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DIFFICULTE = "difficulte";
    private static final String COLUMN_CARACTERISTIQUE = "caracteristique";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_FREQUENCE = "frequence";
    public static final String COLUMN_DATE = "date";
    //Table PERSONNAGE
    public static final String TABLE_PERSO = "Personnage";
    public static final String COLUMN_CLASSE = "classe";
    public static final String COLUMN_NIVEAU = "niveau";
    public static final String COLUMN_FORCE = "force";
    public static final String COLUMN_INTELLIGENCE = "intelligence";
    public static final String COLUMN_AGILITE = "agilite";
    public static final String COLUMN_PV = "pv";
    public static final String COLUMN_XP = "xp";
    public static final String COLUMN_ARGENT = "argent";

    private static final String DATABASE_NAME = "heroofmylife.db";

    private static final int DATABASE_VERSION = 1;


    // Commande sql pour la création de la base de données
    private static final String CREATE_TODO = "create table "+ TABLE_TODO + "("
                                +COLUMN_ID + " integer primary key autoincrement, "
                                +COLUMN_NOM + " text not null, "
                                +COLUMN_DESCRIPTION+ " text not null, "
                                +COLUMN_DIFFICULTE+ " integer not null, "
                                +COLUMN_CARACTERISTIQUE+" integer not null, "
                                +COLUMN_TYPE+ " text not null, "
                                +COLUMN_FREQUENCE+ " integer, "
                                +COLUMN_DATE+ " long "+");";
    private static final String CREATE_PERSO = "create table "+ TABLE_PERSO + "("
            +COLUMN_ID + " integer primary key autoincrement, "
            +COLUMN_CLASSE + " text not null, "
            +COLUMN_NIVEAU+ " integer not null, "
            +COLUMN_FORCE+ " integer not null, "
            +COLUMN_INTELLIGENCE+ " integer not null, "
            +COLUMN_AGILITE+ " integer not null, "
            +COLUMN_PV+ " integer not null, "
            +COLUMN_XP+ " integer not null, "
            +COLUMN_ARGENT+ " integer not null "+");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TODO);
        sqLiteDatabase.execSQL(CREATE_PERSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSO);

        // create new tables
        onCreate(sqLiteDatabase);
    }

    //fonction CREATE
    public long createToDo(Tache todo,String type) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, todo.getId());
        values.put(COLUMN_NOM, todo.getNom());
        values.put(COLUMN_DESCRIPTION, todo.getDescription());
        values.put(COLUMN_DIFFICULTE, todo.getDiff());
        values.put(COLUMN_TYPE,type.toLowerCase());
        values.put(COLUMN_CARACTERISTIQUE, todo.getCategorie());

        switch (type.toLowerCase()){
            case "deadline":
                values.put(COLUMN_DATE, ((ToDoDeadline)todo).getDeadLine());
                break;
            case "frequence":
                values.put(COLUMN_FREQUENCE, ((ToDoRegulier)todo).getFrequence());
                break;
        }

        // insert row
        long todo_id = db.insert(TABLE_TODO, null, values);

        return todo_id;
    }

    public long createJoueur(Joueur j) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,0);
        values.put(COLUMN_CLASSE, j.getClasse().toString());
        values.put(COLUMN_NIVEAU,j.getLevel());
        values.put(COLUMN_FORCE,j.getCaracteristiques()[1].getLevel());
        values.put(COLUMN_INTELLIGENCE,j.getCaracteristiques()[0].getLevel());
        values.put(COLUMN_AGILITE,j.getCaracteristiques()[2].getLevel());
        values.put(COLUMN_PV,j.GetPv());
        values.put(COLUMN_XP,j.getExp());
        values.put(COLUMN_ARGENT,j.getArgent());

        // insert row
        long id = db.insert(TABLE_PERSO, null, values);

        return id;
    }
    //SELECT

    public ArrayList<Tache> getAllToDos(String type) {
        ArrayList<Tache> todos = new ArrayList<Tache>();
        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "+ COLUMN_TYPE + " = \"" + type.toLowerCase()+"\"";

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex(COLUMN_ID));
                String nom =c.getString(c.getColumnIndex(COLUMN_NOM));
                String desc = c.getString(c.getColumnIndex(COLUMN_DESCRIPTION));
                int diff =  c.getInt(c.getColumnIndex(COLUMN_DIFFICULTE));
                int caracteristique = c.getInt(c.getColumnIndex(COLUMN_CARACTERISTIQUE));
                Tache td= null;
                switch(c.getString(c.getColumnIndex(COLUMN_TYPE))){
                    case "deadline":
                        td = new ToDoDeadline(id,nom, desc, diff, c.getLong(c.getColumnIndex(COLUMN_DATE)), caracteristique);
                        break;
                    case "frequence":
                        td = new ToDoRegulier(id,nom, desc, diff,  c.getInt(c.getColumnIndex(COLUMN_FREQUENCE)), caracteristique);
                        break;
                    default:
                        td = new ToDoNormal(id, nom, desc, diff, caracteristique);
                        break;
                }

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }
        c.close();
        return todos;
    }

    public Joueur getJoueur() {
        String selectQuery = "SELECT * FROM " + TABLE_PERSO +" WHERE "+COLUMN_ID +" = "+String.valueOf(0);

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        Joueur j = null;

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            int id = c.getInt(c.getColumnIndex(COLUMN_ID));
           String classe = c.getString(c.getColumnIndex(COLUMN_CLASSE));
           int level = c.getInt(c.getColumnIndex(COLUMN_NIVEAU));
           int force = c.getInt(c.getColumnIndex(COLUMN_FORCE));
           int intelligence = c.getInt(c.getColumnIndex(COLUMN_INTELLIGENCE));
           int agi = c.getInt(c.getColumnIndex(COLUMN_AGILITE));
           int pv = c.getInt(c.getColumnIndex(COLUMN_PV));
           int xp = c.getInt(c.getColumnIndex(COLUMN_XP));
            int argent = c.getInt(c.getColumnIndex(COLUMN_ARGENT));
           j = new Joueur.Builder().setClasse(Classe.valueOf(classe)).setNiveau(level).setAgilite(agi).setForce(force).setIntelligence(intelligence).setId(id).setPv(pv).setArgent(argent).setExp(xp).create();
        }
        c.close();
        return j;
    }
    //UPDATE

    public int updateJoueur(Joueur j) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CLASSE, j.getClasse().toString());
        values.put(COLUMN_NIVEAU,j.getLevel());
        values.put(COLUMN_FORCE,j.getCaracteristiques()[0].getLevel());
        values.put(COLUMN_INTELLIGENCE,j.getCaracteristiques()[1].getLevel());
        values.put(COLUMN_AGILITE,j.getCaracteristiques()[2].getLevel());
        values.put(COLUMN_PV,j.GetPv());
        values.put(COLUMN_XP,j.getExp());
        values.put(COLUMN_ARGENT,j.getArgent());

        // updating row
        return db.update(TABLE_PERSO, values, COLUMN_ID + " = "+String.valueOf(0),null);
    }
    //DELETE
    public void deleteToDo(int todo_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(todo_id);
        System.out.println(db.delete(TABLE_TODO, COLUMN_ID + " = " + String.valueOf(todo_id),null));
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
