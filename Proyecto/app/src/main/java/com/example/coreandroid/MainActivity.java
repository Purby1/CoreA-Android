package com.example.coreandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private EditText texto_Introducido;
    private Button boton_Traduccion;
    private Button boton_Siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        texto = findViewById(R.id.texto_Bienvenida);
        texto_Introducido = findViewById(R.id.texto_Editable);
        boton_Traduccion = findViewById(R.id.boton_Traduccion);
        boton_Siguiente = findViewById(R.id.boton_CambioActividad);

        boton_Traduccion.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(texto.getText().equals("Hello World!"))
                    texto.setText("Hola Mundo!");
                else
                    texto.setText("Hello World!");
            }
        });

        boton_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecogeTexto.class);
                intent.putExtra("texto_introducido", texto_Introducido.getText().toString());
                startActivity(intent);
            }
        });

    }
}