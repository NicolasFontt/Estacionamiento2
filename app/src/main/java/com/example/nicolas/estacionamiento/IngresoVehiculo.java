package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;

public class IngresoVehiculo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText  txtPatente;
    DataBase baseDeDatos;
    String sitio = "1";
    Auto auto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        baseDeDatos = new DataBase(this);


        txtPatente = findViewById(R.id.text_patente);

        Spinner spinner = findViewById(R.id.spinnner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sitios, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void cancelar(View view) {
        startActivity(new Intent(IngresoVehiculo.this,Home.class));
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void agregarVehiculo(View view) {

        if(txtPatente.getText().toString().equals("") || sitio.equals("")) {
            Toast.makeText(this, "Los campos no pueden ir vacios", Toast.LENGTH_SHORT).show();
        } else {
            if(baseDeDatos.getSitioUsado(sitio)){
                Toast.makeText(IngresoVehiculo.this, "Sitio "+ sitio +" usado, elije otro", Toast.LENGTH_LONG).show();
            } else {
                auto = new Auto();
                String horaActual =  LocalDateTime.now().toString();
                int index = horaActual.indexOf('.');
                String fechaFormateada = horaActual.substring(0, index);

                auto.setHora_llegada(fechaFormateada);
                auto.setPatente(txtPatente.getText().toString());
                auto.setSitio(sitio);

                if(baseDeDatos.agregarAuto(auto)) {
                    Toast.makeText(IngresoVehiculo.this, "Auto agregado", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(IngresoVehiculo.this,Home.class));
                } else {
                    Toast.makeText(IngresoVehiculo.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        sitio = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}