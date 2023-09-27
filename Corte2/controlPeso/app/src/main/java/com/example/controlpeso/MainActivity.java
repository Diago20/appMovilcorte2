package com.example.controlpeso;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, apellido, edad, altura, peso;
    private RadioGroup sexo;
    private Button enviar;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        edad = findViewById(R.id.edad);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        sexo = findViewById(R.id.sexo);
        enviar = findViewById(R.id.enviar);
        error = findViewById(R.id.error);

        nombre.setHint("Nombre");
        apellido.setHint("Apellido");
        edad.setHint("Edad");
        altura.setHint("Altura en Cm");
        peso.setHint("Peso en Kg");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nombre = nombre.getText().toString();
                String Apellido = apellido.getText().toString();
                String Edad = edad.getText().toString();
                String Altura = altura.getText().toString();
                String Peso = peso.getText().toString();
                int select = sexo.getCheckedRadioButtonId();
                String genero = "";

                if (select == R.id.femenino) {
                    genero = "Femenino";
                } else if (select == R.id.masculino) {
                    genero = "Masculino";
                } else {
                    error.setText("Seleccionar una opción de sexo");
                    return;
                }

                if (Nombre.isEmpty() || Apellido.isEmpty() || Edad.isEmpty() || Altura.isEmpty() || Peso.isEmpty() || genero.isEmpty()) {
                    error.setText("Por favor, ingrese todos los datos");
                } else {
                    // Validar los datos de altura, edad y peso
                    if (esNumero(Altura) && esNumero(Edad) && esNumero(Peso)) {
                        // Convertir los datos
                        double peso2 = Double.parseDouble(Peso);
                        double altura2 = Double.parseDouble(Altura);
                        int edad2 = Integer.parseInt(Edad);

                        // Crear la conexión
                        Intent intent = new Intent(MainActivity.this, recomendacion.class);

                        // Pasar la información
                        intent.putExtra("nombre", Nombre);
                        intent.putExtra("apellido", Apellido);
                        intent.putExtra("altura2", altura2);
                        intent.putExtra("edad2", edad2);
                        intent.putExtra("peso2", peso2);
                        intent.putExtra("sexo", genero);

                        startActivity(intent);
                    } else {
                        error.setText("Ingresar solo valores numéricos en las casillas de edad, altura y peso");
                    }
                }
            }
        });
    }

    // Verificación si es número
    private boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
