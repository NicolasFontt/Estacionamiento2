package com.example.nicolas.estacionamiento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaAutos extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private TextView cantidadAutos;
    private ListView listaAutos;
    private AdaptadorAuto adaptador;
    private ArrayList<Auto> autos;
    DataBase baseDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_autos);

        baseDeDatos = new DataBase(this);

        listaAutos = findViewById(R.id.listaAutos);
        listaAutos.setOnItemClickListener(this);

        autos = baseDeDatos.getAutos();
        adaptador = new AdaptadorAuto(this, autos);
        listaAutos.setAdapter(adaptador);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
        String id = String.valueOf(autos.get(indice).getId());
        Auto auto = autos.get(indice);
        Toast.makeText(ListaAutos.this, "Mostrar Auto: " + auto.getPatente(), Toast.LENGTH_LONG).show();
    }
}