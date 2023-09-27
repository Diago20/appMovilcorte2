package com.example.controlpeso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class recomendacion extends AppCompatActivity {

    private TextView recomendacion;

    private ImageView estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendacion);
        recomendacion = findViewById(R.id.recomendacion);
        estado = findViewById(R.id.estado);

        Intent intent = getIntent();
        if (intent != null){
            String nombre = intent.getStringExtra("nombre");
            String apellido = intent.getStringExtra("apellido");
            double altura = intent.getDoubleExtra("altura2",0);
            int edad = intent.getIntExtra("edad2",0);
            double peso = intent.getDoubleExtra("peso2",0);
            String genero = intent.getStringExtra("genero");

            double imc = calcularIMC(altura,peso);

            String estadoObesidad = obtenerEstadoObesidad(imc);

            String resultado = "Nombre: " + nombre + " " + apellido + "\n"
                    + "Altura: " + altura + " metros\n"
                    + "Edad: " + edad + " años\n"
                    + "Sexo: " + genero + "\n"
                    + "IMC: " + imc + "\n"
                    + "Estado de obesidad: " + estadoObesidad;
            recomendacion.setText(resultado);
        }
    }
    private double calcularIMC(double altura, double peso) {
        return peso / (altura * altura);
    }

    private String obtenerEstadoObesidad(double imc) {
        int imagenId;
        String textoEstado;
        if (imc < 18.5) {
            imagenId = R.drawable.delgado;
            textoEstado = "Delgado: Come con más frecuencia. Empieza poco a poco a hacer de 5 a 6 comidas más pequeñas durante el día. ...\n" +
                    "Elige alimentos con muchos nutrientes. ...\n" +
                    "Agrega aderezos. ...\n" +
                    "Prueba licuados y batidos de frutas. ...\n" +
                    "Controla qué bebes y cuándo. ...\n" +
                    "Haz ejercicio.";
        } else if (imc < 24.9) {
            imagenId = R.drawable.normal;
            textoEstado = "Peso normal: Para mantener un peso saludable evite los alimentos densos en calorías. Y evite las bebidas azucaradas. - El tamaño de las porciones también cuenta, porciones más grandes de alimentos son más calorías. - Las grasas saturadas y grasas trans son nocivas para la salud.";
        } else if (imc < 29.9) {
            imagenId = R.drawable.sobrepeso;
            textoEstado = "Sobrepeso:  Hacer un diagnóstico para descartar enfermedades que normalmente provocan obesidad.\n" +
                    "El movimiento quema calorías, por lo que se debe evitar el sedentarismo.\n" +
                    "Elige tener una alimentación saludable. ...\n" +
                    "Descansa, duerme 7 a 8 horas por día.\n" +
                    "Reduce el tamaño de las porciones.";
        } else {
            imagenId = R.drawable.obesidad;
            textoEstado = "Obesidad: lan de alimentación saludable y de actividad física regular. ...\n" +
                    "Cambiar los hábitos. ...\n" +
                    "Programas para controlar el peso. ...\n" +
                    "Medicamentos para perder peso. ...\n" +
                    "Dispositivos para perder peso. ...\n" +
                    "Cirugía bariátrica. ...\n" +
                    "Dietas especiales.";
        }
        return textoEstado;
    }
}