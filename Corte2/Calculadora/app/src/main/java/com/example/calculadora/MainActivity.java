package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText texto1;
    private EditText texto2;
    private TextView tvRes;
    private Button Suma;
    private Button Resta;
    private Button Division;
    private Button Multiplicacion;

    public MainActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        tvRes = findViewById(R.id.tvRes);
        Suma = findViewById(R.id.Suma);
        Resta = findViewById(R.id.Resta);
        Division = findViewById(R.id.Division);
        Multiplicacion = findViewById(R.id.Multiplicacion);
        Suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(texto1.getText().toString());
                double numero2 = Double.parseDouble(texto2.getText().toString());

                if (numero1 >= 0 && numero2 >= 0) {
                    double sumar = numero1 + numero2;
                    // Convierte a cadena de texto antes de mostrar
                    tvRes.setText(String.valueOf(sumar));
                } else {
                    tvRes.setText("Debe de ingresar números positivos");
                }
            }
        });

        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(texto1.getText().toString());
                double numero2 = Double.parseDouble(texto2.getText().toString());

                if (numero1 >= 0 && numero2 >= 0) {
                    double resta = numero1 - numero2;
                    tvRes.setText(String.valueOf(resta));
                } else {
                    tvRes.setText("Debe ingresar números positivos");
                }
            }
        });

        Multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(texto1.getText().toString());
                double numero2 = Double.parseDouble(texto2.getText().toString());

                if (numero1 >= 0 && numero2 >= 0) {
                    double multiplicacion = numero1 * numero2;
                    tvRes.setText(String.valueOf(multiplicacion));
                } else {
                    tvRes.setText("Debe ingresar números positivos");
                }
            }
        });

        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(texto1.getText().toString());
                double numero2 = Double.parseDouble(texto2.getText().toString());

                if (numero1 >= 0 && numero2 >= 0) {
                    if (numero2 != 0) {
                        double division = numero1 / numero2;
                        tvRes.setText(String.valueOf(division));
                    } else {
                        tvRes.setText("No se puede dividir por 0");
                    }
                } else {
                    tvRes.setText("Debe ingresar números positivos");
                }
            }
        });

    });
    }
