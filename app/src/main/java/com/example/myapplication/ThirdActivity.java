package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    // Declarar variables para los elementos de la interfaz de usuario en ThirdActivity
    private TextView textViewNombre, textViewApellido, textViewRut, textViewDestino,
            textViewLineaAerea, textViewCiudadEmbarque, textViewValorPasaje,
            textViewCiudadEmbarqueRegreso, textViewValorPasajeRegreso,
            textViewTotalNeto, textViewTotalIVA, textViewTotalPagar;
    private Button btnVolver, btnVolverInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Configurar referencias a los elementos del XML en ThirdActivity
        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewRut = findViewById(R.id.textViewRut);
        textViewDestino = findViewById(R.id.textViewDestino);
        textViewLineaAerea = findViewById(R.id.textViewLineaAerea);
        textViewCiudadEmbarque = findViewById(R.id.textViewCiudadEmbarque);
        textViewValorPasaje = findViewById(R.id.textViewValorPasaje);
        textViewCiudadEmbarqueRegreso = findViewById(R.id.textViewCiudadEmbarqueRegreso);
        textViewValorPasajeRegreso = findViewById(R.id.textViewValorPasajeRegreso);
        textViewTotalNeto = findViewById(R.id.textViewTotalNeto);
        textViewTotalIVA = findViewById(R.id.textViewTotalIVA);
        textViewTotalPagar = findViewById(R.id.textViewTotalPagar);

        btnVolverInicio = findViewById(R.id.btnVolverInicio);


        // Recibir los datos pasados desde la segunda pantalla utilizando Intents
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String rut = intent.getStringExtra("rut");
        String destino = intent.getStringExtra("destino");
        String lineaAerea = intent.getStringExtra("lineaAerea");
        String ciudadEmbarque = intent.getStringExtra("ciudadEmbarque");
        String valorPasaje = intent.getStringExtra("valorPasaje");
        String ciudadEmbarqueRegreso = intent.getStringExtra("ciudadEmbarqueRegreso");
        String valorPasajeRegreso = intent.getStringExtra("valorPasajeRegreso");

        // Mostrar los datos recibidos en los TextView correspondientes de ThirdActivity
        textViewNombre.setText("Nombre: " + nombre);
        textViewApellido.setText("Apellido: " + apellido);
        textViewRut.setText("RUT: " + rut);
        textViewDestino.setText("Destino: " + destino);
        textViewLineaAerea.setText("Línea Aérea: " + lineaAerea);
        textViewCiudadEmbarque.setText("Ciudad de Embarque: " + ciudadEmbarque);
        textViewValorPasaje.setText("Valor del Pasaje: " + valorPasaje);
        textViewCiudadEmbarqueRegreso.setText("Ciudad de Embarque (Regreso): " + ciudadEmbarqueRegreso);
        textViewValorPasajeRegreso.setText("Valor del Pasaje (Regreso): " + valorPasajeRegreso);

        double valorNeto = Double.parseDouble(valorPasaje) + Double.parseDouble(valorPasajeRegreso);
        double iva = valorNeto * 0.19;
        double totalPagar = valorNeto + iva;


        // Configurar los TextView con los valores de los nuevos campos
        textViewTotalNeto.setText("Total Neto: " + valorNeto);
        textViewTotalIVA.setText("Total del IVA (19%): " + iva);
        textViewTotalPagar.setText("Valor Total a Pagar: " + totalPagar);


        // Configurar el botón "Volver al Inicio" para regresar a la pantalla principal (MainActivity)
        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para volver a la pantalla principal (MainActivity)
                Intent intentVolverInicio = new Intent(ThirdActivity.this, MainActivity.class);
                // Iniciar la pantalla principal
                startActivity(intentVolverInicio);
            }
        });
    }
}
