package com.example.coreandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText nombre_Introducido;
    private EditText apellidos_Introducido;
    private EditText numero_Introducido;
    private Button boton_Siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_Introducido = findViewById(R.id.editable_Nombre);
        apellidos_Introducido = findViewById(R.id.editable_Apellidos);
        numero_Introducido = findViewById(R.id.editable_Numero);
        boton_Siguiente = findViewById(R.id.boton_CambioActividad);


        boton_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario nuevoUsuario = new Usuario(
                        nombre_Introducido.getText().toString(),
                        apellidos_Introducido.getText().toString(),
                        Integer.parseInt(numero_Introducido.getText().toString()));

                Intent intent = new Intent(MainActivity.this, RecogeTexto.class);
                intent.putExtra("usuario_introducido", nuevoUsuario);
                startActivity(intent);
            }
        });

    }
}