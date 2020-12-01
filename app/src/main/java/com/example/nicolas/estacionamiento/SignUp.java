package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private EditText textCorreo, textPassword, textTelefono, textNombre;

    DataBase baseDeDatos;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textCorreo = findViewById(R.id.text_correo);
        textNombre = findViewById(R.id.text_nombre);
        textPassword = findViewById(R.id.text_password);
        textTelefono = findViewById(R.id.text_telefono);

        baseDeDatos = new DataBase(this);

    }

    public void crearUsuario(View view) {
        usuario = new Usuario();
        usuario.setNombre(textNombre.getText().toString());
        usuario.setEmail(textCorreo.getText().toString());
        usuario.setTelefono(textTelefono.getText().toString());
        usuario.setPassword(textPassword.getText().toString());

        if( baseDeDatos.nuevoUsuario(usuario) ){
            Toast.makeText(SignUp.this, "Usuario registrado!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(SignUp.this,Login.class));
            finish();
        } else {
            Toast.makeText(SignUp.this, "Error al registrar", Toast.LENGTH_LONG).show();
        }

    }

    public void irAInicioSesion(View view) {
        startActivity(new Intent(SignUp.this,Login.class));
        finish();
    }
}
