package com.example.memos2021.donnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDonnees extends SQLiteOpenHelper {

    private static BaseDeDonnees instance = null;

    public static synchronized BaseDeDonnees getInstance(Context contexte)
    {
        instance = new BaseDeDonnees(contexte);
        return instance;
    }
    public static BaseDeDonnees getInstance()
    {
       return instance;
    }

    public BaseDeDonnees(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    public BaseDeDonnees(Context contexte) {
        super(contexte, "listeMemos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "create table table_memo(id INTEGER PRIMARY KEY, activite TEXT, date TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onOpen(SQLiteDatabase db){
        //La première fois cela créé l'échafaud, à la seconde exécution, il faut commenter cette méthode car la table est déjà remplie OK FAIT

        /*String DELETE = "delete from table_memo where 1 = 1";
        db.execSQL(DELETE);

        String INSERT_1 = "insert into table_memo(activite,date) VALUES('Scéance de cinéma avec les amis film Là Haut','12 Juillet 15h20')";
        String INSERT_2 = "insert into table_memo(activite,date) VALUES('Parc Festiland avec mes amis du lycée','24 Mars de 13h à 19h')";
        String INSERT_3 = "insert into table_memo(activite,date) VALUES('Parc aquatique H2O avec ma tante, ma cousine, ma mère, mon frère et ma soeur','12 Février de 14h à 17h30')";

        db.execSQL(INSERT_1);
        db.execSQL(INSERT_2);
        db.execSQL(INSERT_3);*/

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
        //String DETRUIRE_TABLE = "drop table table_memo";
        //db.execSQL(DETRUIRE_TABLE);
        String CREER_TABLE = "create table table_memo(id INTEGER PRIMARY KEY, activite TEXT, date TEXT)";
        db.execSQL(CREER_TABLE);

    }

}
