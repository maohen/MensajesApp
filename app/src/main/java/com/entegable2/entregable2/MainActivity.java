package com.entegable2.entregable2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    int[] idImagen = {
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
    };

    String[] nombre = {
            "Juan Camilo",
            "Jean Paul",
            "Craig",
            "Mike",
            "Ivana",
            "Michelle Molina"
    };

    String[] mensaje = {
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry standard dummy text ever since the 1500s, when an",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry standard dummy text ever since ",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry when an",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry standard dummy text ever since the 1500s, when an",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
    };

    String[] asuntoMensaje ={
            "Hey", "What´s Up","Nos vemos hoy?","Qué haces?","Wie heist du?","Gotta go"
    };

    String[] horaUltimoMensaje ={
            "10:30", "20:50","00:01","03:44","10:45","13:56"
    };
    String[] numeroTelefono ={
            "2222", "33344","89764","8765243","908765","12989"
    };

    String[] pais ={
            "Colombia", "USA","Colombia","Perú","Alemania","Suiza"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] mensajeCorto = mensaje.clone();

        for (int i =0; i < mensajeCorto.length; i++){
            if(mensajeCorto[i].length() >= 77){
                mensajeCorto[i] = mensajeCorto[i].substring(0, 77) + "...";
            }
        }

        ListAdapter listAdapter = new ListAdapter(MainActivity.this, nombre, asuntoMensaje, mensajeCorto ,horaUltimoMensaje,numeroTelefono, pais,idImagen);
        lista = (ListView) findViewById(R.id.listaView);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                //Toast.makeText(MainActivity.this, "Presióno "+posicion, Toast.LENGTH_SHORT).show();

                gotoViewMessage(posicion, view);
            }
        });

    }

    public void gotoViewMessage(int posicion, View view) {
        Intent intent = new Intent(this, viewMessage.class);
        intent.putExtra("nombre",nombre[posicion]);
        intent.putExtra("telefono",numeroTelefono[posicion]);
        intent.putExtra("asunto",asuntoMensaje[posicion]);
        intent.putExtra("pais",pais[posicion]);
        intent.putExtra("mensaje",mensaje[posicion]);
        startActivity(intent);
    }
}