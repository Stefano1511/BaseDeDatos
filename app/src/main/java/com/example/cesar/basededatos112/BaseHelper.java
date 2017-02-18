package com.example.cesar.basededatos112;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cesar on 08/02/2017.
 */

public class BaseHelper extends SQLiteOpenHelper{

    String tabla="CREATE TABLE Personas (Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre Text, Apellido Text, Edad Integer)";


    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //Para las actualizaciones de la base de datos, aca coloco los metodos
            db.execSQL(tabla);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
