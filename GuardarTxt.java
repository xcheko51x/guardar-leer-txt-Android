package com.example.xcheko51x.guardartxt;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GuardarTxt extends AppCompatActivity {

    EditText etTexto;
    Button btnGuardarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_txt);

        etTexto = findViewById(R.id.etTexto);
        btnGuardarTxt = findViewById(R.id.btnGuardarTxt);

        btnGuardarTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarArchivo();
            }
        });
    }

    public void guardarArchivo() {
        try {
            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("ArchivoHola.txt", Context.MODE_PRIVATE));
            fout.write(etTexto.getText().toString());
            fout.close();
            leerArchivo();
        } catch(Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void leerArchivo() {
        try {
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("ArchivoHola.txt")));
            String texto = fin.readLine();
            Toast.makeText(this, "TEXTO EN EL ARCHIVO: "+texto, Toast.LENGTH_LONG).show();
        } catch(Exception ex) {
            Log.e("Ficheros", "Error al leer el fichero desde la memoria interna");
        }
    }
}
