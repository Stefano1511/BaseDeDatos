package com.example.cesar.basededatos112;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Segunda extends AppCompatActivity {


    public void cargar(){

        BaseHelper baseHelper = new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db!=null) {

            Cursor c = db.rawQuery("select * from Persona", null);
             int cantidad= c.getCount();
             int i=0;
             String[] arreglo = new String[cantidad];
             if (c.moveToFirst()){
                 do {
                     String linea = c.getInt(0)+""+c.getString(1)+""+c.getString(2)+""+c.getString(3); //autoincremente + nombre+apellido + edad

                     arreglo[i] = linea;
                     i++;
                 }while (c.moveToNext()); //Mientras hay un registro
             }

            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arreglo);

            ListView lista = (ListView) findViewById(R.id.Lista);
            lista.setAdapter(adapter);





        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        cargar();
    }
}
