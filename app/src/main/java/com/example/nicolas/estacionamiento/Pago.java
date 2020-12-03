package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pago extends AppCompatActivity {
    TextView txt_patente, txt_hora_llegada, txt_puesto, txt_tiempo, txt_total_pagar;
    String id_auto;
    Button btn_pago;

    DataBase baseDeDatos;
    Auto auto;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        baseDeDatos = new DataBase(this);
        id_auto =  getIntent().getExtras().getString("id_auto");

        txt_patente=findViewById(R.id.txt_patente);
        txt_hora_llegada = findViewById(R.id.txt_hora_llegada);
        txt_puesto = findViewById(R.id.txt_puesto);
        txt_tiempo = findViewById(R.id.txt_tiempo);
        txt_total_pagar = findViewById(R.id.txt_total_pagar);
        btn_pago = findViewById(R.id.btn_pago);
        auto = baseDeDatos.getAutoPorID(id_auto);

        txt_tiempo.setText(String.valueOf(auto.obtenerMinutos()));
        txt_total_pagar.setText("$"+ auto.precioAPagar());
        txt_patente.setText(auto.getPatente());
        txt_hora_llegada.setText(auto.obtenerHoraFormateada());
        txt_puesto.setText(auto.getSitio());
        btn_pago.setText("Pagar $" + auto.precioAPagar());
//        Toast.makeText(this,"Hora: "+ auto.obtenerHoraFormateada(), Toast.LENGTH_LONG).show();
    }


    public void pagarEstacionamiento(View view) {
        if( baseDeDatos.borrarAutoAlPagar(id_auto) ) {
            Toast.makeText(this,"Pago correcto! ", Toast.LENGTH_LONG).show();
            // Aqui realizar algo con el bluetooth
            Intent i = new Intent(Pago.this, Home.class);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(this,"Error al pagar", Toast.LENGTH_LONG).show();
        }

    }
}