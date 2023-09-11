package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declarar variables para los elementos de la interfaz de usuario
    private EditText editTextNombre, editTextApellido, editTextRut, editTextDestino ;
    private Button btnEnviar, btnBorrar;

    private TextView textViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Configurar referencias a los elementos del XML
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextRut = findViewById(R.id.editTextRut);
        editTextDestino = findViewById(R.id.editTextDestino);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnBorrar = findViewById(R.id.btnBorrar);
        textViewError = findViewById(R.id.textViewError);

        // Configurar el botón "Enviar"
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores ingresados por el usuario
                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();
                String rut = editTextRut.getText().toString();
                String destino = editTextDestino.getText().toString();

                // Validar el formato del RUT
                if (!rut.matches("[0-9]+") || rut.length() != 8) {
                    Toast.makeText(MainActivity.this, "El RUT debe contener solo números, sin puntos ni guiones y tener 8 dígitos.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (nombre.isEmpty() || apellido.isEmpty() || rut.isEmpty() || destino.isEmpty()) {
                    textViewError.setText("Todos los campos son obligatorios.");
                    return;
                }


                // Crear un Intent para pasar datos a la segunda pantalla
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                intent.putExtra("rut", rut);
                intent.putExtra("destino", destino);

                // Iniciar la segunda pantalla
                startActivity(intent);
            }
        });

        // Configurar el botón "Borrar"
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Borrar los campos de entrada
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextRut.setText("");
                editTextDestino.setText("");
            }
        });
    }
}
