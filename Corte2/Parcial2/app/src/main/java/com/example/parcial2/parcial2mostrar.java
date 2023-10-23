package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class parcial2mostrar extends AppCompatActivity {
    private TextView[] nombreTextViews = new TextView[7];
    private TextView[] cantidadTextViews = new TextView[7];
    private TextView[] valorTextViews = new TextView[7];
    private TextView[] subtotalTextViews = new TextView[7];
    private TextView[] impuestoTextViews = new TextView[7];
    private TextView[] totalTextViews = new TextView[7];
    private double resultadoSubtotal = 0.0;
    private double resultadoImpuesto = 0.0;
    private double resultadoTotal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial2mostrar);

        // Inicializa todas las vistas
        for (int i = 0; i < 7; i++) {
            nombreTextViews[i] = findViewById(getResources().getIdentifier("nombre" + (i + 1), "id", getPackageName()));
            cantidadTextViews[i] = findViewById(getResources().getIdentifier("cantidad" + (i + 1), "id", getPackageName()));
            valorTextViews[i] = findViewById(getResources().getIdentifier("valor" + (i + 1), "id", getPackageName()));
            subtotalTextViews[i] = findViewById(getResources().getIdentifier("subtotal" + (i + 1), "id", getPackageName()));
            impuestoTextViews[i] = findViewById(getResources().getIdentifier("impuesto" + (i + 1), "id", getPackageName()));
            totalTextViews[i] = findViewById(getResources().getIdentifier("total" + (i + 1), "id", getPackageName()));
        }

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        for (int i = 0; i < 7; i++) {
            String nombre = extras.getString("nombre" + i, "");
            int cantidad = extras.getInt("cantidad" + i, 0);
            double valor = extras.getDouble("valor" + i, 0.0);

            nombreTextViews[i].setText("Nombre: " + nombre);
            cantidadTextViews[i].setText("Cantidad: " + cantidad);
            valorTextViews[i].setText("Valor: " + valor);

            double subtotal = cantidad * valor;
            subtotalTextViews[i].setText("Subtotal: " + subtotal);
            resultadoSubtotal += subtotal;

            double impuesto = subtotal * 0.19; // 19% de impuesto
            impuestoTextViews[i].setText("Impuesto: " + impuesto);
            resultadoImpuesto += impuesto;

            double total = subtotal + impuesto;
            totalTextViews[i].setText("Total: " + total);
            resultadoTotal += total;
        }

        // Mostrar los resultados finales
        TextView resultadoSubtotalTextView = findViewById(R.id.subtotal);
        resultadoSubtotalTextView.setText("Resultado Subtotal: " + resultadoSubtotal);

        TextView resultadoImpuestoTextView = findViewById(R.id.impuesto);
        resultadoImpuestoTextView.setText("Resultado Impuesto: " + resultadoImpuesto);

        TextView resultadoTotalTextView = findViewById(R.id.totalGeneral);
        resultadoTotalTextView.setText("Resultado Total: " + resultadoTotal);
    }
}
