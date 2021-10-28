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

    private EditText nombre_Introducido;
    private EditText apellidos_Introducido;
    private EditText numero_Introducido;
    private TextView nombre_Ultimo;
    private TextView apellidos_Ultimo;
    private TextView numero_Ultimo;
    private Button boton_Siguiente;
    private TinyDB tinyDB;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre_Introducido = findViewById(R.id.editable_Nombre);
        apellidos_Introducido = findViewById(R.id.editable_Apellidos);
        numero_Introducido = findViewById(R.id.editable_Numero);
        boton_Siguiente = findViewById(R.id.boton_CambioActividad);

        nombre_Ultimo = findViewById(R.id.ultimo_Nombre);
        apellidos_Ultimo = findViewById(R.id.ultimo_Apellidos);
        numero_Ultimo = findViewById(R.id.ultimo_Numero);

        tinyDB = new TinyDB(this);

        try {
            nombre_Ultimo.setText(tinyDB.getObject("ultimo_usuario",Usuario.class).getNombre());
            apellidos_Ultimo.setText(tinyDB.getObject("ultimo_usuario",Usuario.class).getApellidos());
            numero_Ultimo.setText(tinyDB.getObject("ultimo_usuario",Usuario.class).getNumero());
        } catch (Exception e) {
            e.printStackTrace();
            nombre_Ultimo.setText("Nadie se ha registrado aún :(");
            apellidos_Ultimo.setText("");
            numero_Ultimo.setText("");
        }


        boton_Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario nuevoUsuario = new Usuario(
                        nombre_Introducido.getText().toString(),
                        apellidos_Introducido.getText().toString(),
                        Integer.parseInt(numero_Introducido.getText().toString()));

                Intent intent = new Intent(MainActivity.this, RecogeTexto.class);
                intent.putExtra("usuario_introducido",nuevoUsuario);

                tinyDB.putObject("ultimo_usuario",nuevoUsuario);

                startActivity(intent);
            }
        });

    }
}