package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.appetite.appetite.R;

public class Presentacion extends Activity {
    TextView nombreComida;
    ImageView imagenDeLaComida;
    Bundle dl;
    String nombreTitulo;
    int imagenComida = 0;
    final String NOMBRE = "titulo", IMAGEN = "imagen";

    String[] titulo = new String[]{
            "Entradas",
            "Desayunos",
            "Ensaladas",
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        inicializar();
    }

    private void inicializar(){
        nombreComida = (TextView) findViewById(R.id.nombreComida);
        imagenDeLaComida = (ImageView) findViewById(R.id.imagenComida);
        dl = this.getIntent().getExtras();

        nombreTitulo = dl.getString(NOMBRE);
        imagenComida = dl.getInt(IMAGEN);

        nombreComida.setText(titulo [imagenComida]);
        imagenDeLaComida.setImageResource(imagenes[imagenComida]);
    }
}
