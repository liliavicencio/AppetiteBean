package com.appetite.appetite.model;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.EditText;

import com.appetite.appetite.R;

public class MenuOpciones extends Activity {
    ListViewAdapter adapter;

    String[] titulo = new String[]{
            "Entradas",
            "Desayunos",
            "Ensadalas",
            "Cortes",
            "Hamburguesas",
            "Especialidades",
            "Postres",
            "Bebidas"
    };

    int[] imagenes = {
            R.drawable.entrada,
            R.drawable.desayuno,
            R.drawable.ensalada,
            R.drawable.cortes,
            R.drawable.hamburguesas,
            R.drawable.especialidades,
            R.drawable.postres,
            R.drawable.bebidas
    };
    String nombreTitulo;
    int imagenComida = 0;
    Intent i;
    final String nombre = "titulo", imagen = "imagen";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        Button button1 = (Button) findViewById(R.id.ticket);

        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MenuOpciones.this, ticket.class);
                startActivity(intent);
            }
        });

        inicializar();
    }

    private void inicializar() {
        final ListView lista = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewAdapter(this, titulo, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int e, long l) {
                nombreTitulo = titulo[e];
                imagenComida = e;
                i = new Intent(MenuOpciones.this, Presentacion.class);
                i.putExtra(nombre, nombreTitulo);
                i.putExtra(imagen, imagenComida);
                startActivity(i);
                //Toast.makeText(getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
