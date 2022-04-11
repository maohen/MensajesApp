package com.entegable2.entregable2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewMessage extends AppCompatActivity {

    TextView txtNombre, txtTelefono, txtAsunto, txtPais, txtMensaje;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);
        txtNombre = findViewById(R.id.singleNombre);
        txtTelefono = findViewById(R.id.singleTelefono);
        txtAsunto = findViewById(R.id.singleAsunto);
        txtPais = findViewById(R.id.singlePais);
        txtMensaje = findViewById(R.id.singleMensaje);

        //recibo datos del intent.  recuperando los extras del MainActivity
        //Intent recibidos = getIntent();
        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        String asunto = getIntent().getStringExtra("asunto");
        String pais = getIntent().getStringExtra("pais");
        String mensaje = getIntent().getStringExtra("mensaje");
        //Mostrar los datos
        txtNombre.setText(nombre);
        txtTelefono.setText(telefono);
        txtAsunto.setText(asunto);
        txtPais.setText(pais);
        txtMensaje.setText(mensaje);

    }

    @Override
    protected void onStart() {
        super.onStart();
        boton = findViewById(R.id.botonAtras);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresar = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(regresar);
            }
        });
    }
}