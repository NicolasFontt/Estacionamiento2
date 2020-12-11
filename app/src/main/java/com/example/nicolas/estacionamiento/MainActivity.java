package com.example.nicolas.estacionamiento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nicolas.estacionamiento.R;

public class MainActivity extends AppCompatActivity {

    Button ir_login, btn_REGISTRO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ir_login=findViewById(R.id.ir_login);
        btn_REGISTRO = findViewById(R.id.btn_REGISTRO);

        btn_REGISTRO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
                finish();
            }
        });
        ir_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Login.class));
                finish();
            }
        });
    }
}
