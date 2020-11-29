package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nicolas.estacionamiento.R;
import com.example.nicolas.estacionamiento.SignUp;

public class Login extends AppCompatActivity {

    Button btn_ir_crearCuenta,iniciar_sesion;
    private EditText textCorreo, textPassword;

    DataBase baseDeDatos;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);
        textCorreo = (EditText) findViewById(R.id.text_correo);
        textPassword = (EditText) findViewById(R.id.text_password);

        baseDeDatos = new DataBase(this);

        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, SignUp.class));
                finish();
            }
        });

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = textCorreo.getText().toString();
                String password = textPassword.getText().toString();
                Usuario loginValid = baseDeDatos.isLoginValid(correo, password);
                if(loginValid != null) {
                    Toast.makeText(Login.this, "Bienvendio!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Home.class));
                    finish();
                } else {
                    Toast.makeText(Login.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
