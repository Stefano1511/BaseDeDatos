package com.example.cesar.basededatos112;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText ET_Nombre, ET_Apellido, ET_Edad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_Nombre =  (EditText) findViewById(R.id.ET_Nombre);
        ET_Apellido = (EditText) findViewById(R.id.ET_Apellido);
        ET_Edad = (EditText) findViewById(R.id.ET_Edad);
    }

    public  void GuardarDatos(View vie){
        String nombre = ET_Nombre.getText().toString();
        String apellido = ET_Apellido.getText().toString();
        int edad = Integer.parseInt(ET_Edad.getText().toString());

        BaseHelper baseHelper = new BaseHelper(this,"DEMODB",null,1);
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db!=null){
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Nombre", nombre);
            registronuevo.put("Apellido", apellido);
            registronuevo.put("Edad", edad);
            long i= db.insert("Personas",null,registronuevo);
            if (i>0){
                Toast.makeText(this,"Registo Insertado", Toast.LENGTH_SHORT).show();



            }



        }

    }

    public  void Siguiente(View view){
        Intent i = new Intent(this,Segunda.class);
        startActivity(i);

    }





}
