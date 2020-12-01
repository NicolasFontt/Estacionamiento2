package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

public class IngresoVehiculo extends AppCompatActivity {
    private EditText textSitio, txtPatente;
    DataBase baseDeDatos;
    Auto auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        baseDeDatos = new DataBase(this);

        textSitio = findViewById(R.id.text_sitio);
        txtPatente = findViewById(R.id.text_patente);

//        int cantidad = baseDeDatos.getAutos().size();
//        Toast.makeText(IngresoVehiculo.this, "Autos:"+cantidad, Toast.LENGTH_LONG).show();
    }

    public void cancelar(View view) {
        startActivity(new Intent(IngresoVehiculo.this,Home.class));
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void agregarVehiculo(View view) {
        auto = new Auto();
        String horaActual =  LocalDateTime.now().toString();
        int index = horaActual.indexOf('.');
        String fechaFormateada = horaActual.substring(0, index);

//        Toast.makeText(this, "Hora: " + fechaFormateada, Toast.LENGTH_SHORT).show();
        auto.setHora_llegada(fechaFormateada);
        auto.setPatente(txtPatente.getText().toString());
        auto.setSitio(textSitio.getText().toString());

        if(baseDeDatos.agregarAuto(auto)) {
           Toast.makeText(IngresoVehiculo.this, "Auto agregado", Toast.LENGTH_LONG).show();
            startActivity(new Intent(IngresoVehiculo.this,Home.class));
        } else {
            Toast.makeText(IngresoVehiculo.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
}