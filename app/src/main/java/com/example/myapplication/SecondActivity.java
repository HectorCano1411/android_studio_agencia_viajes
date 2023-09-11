package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    // Declarar variables para los elementos de la interfaz de usuario

    private EditText editTextLineaAerea, editTextCiudadEmbarque, editTextValorPasaje, editTextCiudadEmbarqueRegreso, editTextValorPasajeRegreso;
    private Button btnVolver, btnSiguiente;
    private String Rut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Configurar referencias a los elementos del XML
        editTextLineaAerea = findViewById(R.id.editTextLineaAerea);
        editTextCiudadEmbarque = findViewById(R.id.editTextCiudadEmbarque);
        editTextValorPasaje = findViewById(R.id.editTextValorPasaje);
        editTextCiudadEmbarqueRegreso = findViewById(R.id.editTextCiudadEmbarqueRegreso);
        editTextValorPasajeRegreso = findViewById(R.id.editTextValorPasajeRegreso);
        btnVolver = findViewById(R.id.btnVolver);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        // Recibir los datos pasados desde la primera pantalla utilizando Intents
        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String rut = intent.getStringExtra("rut");
        String destino = intent.getStringExtra("destino");


        // Configurar los TextView con los valores del nombre y el apellido
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewApellido = findViewById(R.id.textViewApellido);
        TextView textViewRut = findViewById(R.id.textViewRut);
        TextView textViewDestino = findViewById(R.id.textViewDestino);


        // Mostrar los datos recibidos en los EditText correspondientes

        textViewNombre.setText("Nombre: " + nombre);
        textViewApellido.setText("Apellido: " + apellido);
        textViewRut.setText("rut: " + rut );
        textViewDestino.setText("destino: " + destino);



        // Configurar el botón "Volver"
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Volver a la primera pantalla
                finish();
            }
        });

        // Configurar el botón "Siguiente"
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores ingresados por el usuario en la segunda pantalla
                String lineaAerea = editTextLineaAerea.getText().toString();
                String ciudadEmbarque = editTextCiudadEmbarque.getText().toString();
                String valorPasaje = editTextValorPasaje.getText().toString();
                String ciudadEmbarqueRegreso = editTextCiudadEmbarqueRegreso.getText().toString();
                String valorPasajeRegreso = editTextValorPasajeRegreso.getText().toString();

                // Obtener los datos pasados desde la primera pantalla
                Intent intentFromPreviousScreen = getIntent();
                String nombre = intentFromPreviousScreen.getStringExtra("nombre");
                String apellido = intentFromPreviousScreen.getStringExtra("apellido");
                String rut = intentFromPreviousScreen.getStringExtra("rut");
                String destino = intentFromPreviousScreen.getStringExtra("destino");
                // Verificar que todos los campos estén llenos

                if (lineaAerea.isEmpty() || ciudadEmbarque.isEmpty() || valorPasaje.isEmpty() || ciudadEmbarqueRegreso.isEmpty() || valorPasajeRegreso.isEmpty()) {
                    // Mostrar un mensaje de error si algún campo está vacío
                    Toast.makeText(SecondActivity.this, "Todos los campos son obligatorios.", Toast.LENGTH_SHORT).show();
                    return; // Salir de la función sin pasar a la tercera pantalla
                }

                // Crear un Intent para pasar todos los datos a la tercera pantalla
                Intent intentToThirdScreen = new Intent(SecondActivity.this, ThirdActivity.class);

                // Agregar todos los datos al Intent
                intentToThirdScreen.putExtra("nombre", nombre);
                intentToThirdScreen.putExtra("apellido", apellido);
                intentToThirdScreen.putExtra("rut", rut);
                intentToThirdScreen.putExtra("destino", destino);
                intentToThirdScreen.putExtra("lineaAerea", lineaAerea);
                intentToThirdScreen.putExtra("ciudadEmbarque", ciudadEmbarque);
                intentToThirdScreen.putExtra("valorPasaje", valorPasaje);
                intentToThirdScreen.putExtra("ciudadEmbarqueRegreso", ciudadEmbarqueRegreso);
                intentToThirdScreen.putExtra("valorPasajeRegreso", valorPasajeRegreso);

                // Iniciar la tercera pantalla
                startActivity(intentToThirdScreen);
                Toast.makeText(SecondActivity.this, "Tu pasaje está OK. ¡Buen viaje!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
