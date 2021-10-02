package com.example.coreandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecogeTexto extends AppCompatActivity {

    private TextView texto_recogido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoge_texto);


        texto_recogido = findViewById(R.id.texto_Recogido);

        Intent intent = getIntent();
        texto_recogido.setText(intent.getStringExtra("texto_introducido"));
    }
}