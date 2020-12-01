package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private TextView txt_ocupados;
    DataBase baseDeDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        baseDeDatos = new DataBase(this);
        txt_ocupados = findViewById(R.id.txt_ocupados);
        txt_ocupados.setText(String.format("%d", baseDeDatos.getAutos().size()));
    }

    public void btn_agregar_Vehiculo(View view) {
        startActivity(new Intent(Home.this,IngresoVehiculo.class));
        finish();
    }

    public void verAutosEnElEstacionamiento(View view) {
        startActivity(new Intent(Home.this,ListaAutos.class));
    }
}