package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText[] nombres= new EditText[7];
    private EditText[] cantidades= new EditText[7];
    private EditText[] valores= new EditText[7];
    private Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres[0] = findViewById(R.id.nombre1);
        cantidades[0] = findViewById(R.id.cantidad1);
        valores[0] = findViewById(R.id.valor1);
        nombres[1] = findViewById(R.id.nombre2);
        cantidades[1] = findViewById(R.id.cantidad2);
        valores[1] = findViewById(R.id.valor2);
        nombres[2] = findViewById(R.id.nombre3);
        cantidades[2] = findViewById(R.id.cantidad3);
        valores[2] = findViewById(R.id.valor3);
        nombres[3] = findViewById(R.id.nombre4);
        cantidades[3] = findViewById(R.id.cantidad4);
        valores[3] = findViewById(R.id.valor4);
        nombres[4] = findViewById(R.id.nombre5);
        cantidades[4] = findViewById(R.id.cantidad5);
        valores[4] = findViewById(R.id.valor5);
        nombres[5] = findViewById(R.id.nombre6);
        cantidades[5] = findViewById(R.id.cantidad6);
        valores[5] = findViewById(R.id.valor6);
        nombres[6] = findViewById(R.id.nombre7);
        cantidades[6] = findViewById(R.id.cantidad7);
        valores[6] = findViewById(R.id.valor7);
        calcular = findViewById(R.id.calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, parcial2mostrar.class);

                // Envía los datos como extras al Intent
                for (int i = 0; i < 7; i++) {
                    intent.putExtra("nombre" + i, nombres[i].getText().toString());
                    intent.putExtra("cantidad" + i, Integer.parseInt(cantidades[i].getText().toString()));
                    intent.putExtra("valor" + i, Double.parseDouble(valores[i].getText().toString()));
                }

                // Inicia la segunda actividad
                startActivity(intent);
            }
        });

    }
}