package com.example.coreandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecogeTexto extends AppCompatActivity {

    private TextView nombre;
    private TextView apellidos;
    private TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoge_texto);


        nombre = findViewById(R.id.nombre_Recogido);
        apellidos = findViewById(R.id.apellidos_Recogido);
        numero = findViewById(R.id.numero_Recogido);

        Intent intent = getIntent();
        Usuario usuarioRecogido = (Usuario) intent.getSerializableExtra("usuario_introducido");
        nombre.setText(usuarioRecogido.getNombre());
        apellidos.setText(usuarioRecogido.getApellidos());
        numero.setText(String.valueOf(usuarioRecogido.getNumero()));
    }
}