package com.appetite.appetite.model;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.appetite.appetite.R;
import com.appetite.appetite.controller.MenuOpcionesController;

public class MenuOpciones extends Activity {
    String MenuOpcion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);


        MenuOpcionesController imageController = new MenuOpcionesController(MenuOpciones.this);
        imageController.execute();


        Button pantalla2 = (Button) findViewById(R.id.button37);
        pantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuOpciones.this, Pago.class));

            }

        });

        final ListView mListView;
        mListView = (ListView) findViewById(R.id.list_menu_opciones);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), Presentacion.class);

                switch(position)
                {
                    case 0:
                        MenuOpcion = "Desayunos";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 1);
                        startActivity(intent);
                        break;

                    case 1:
                        MenuOpcion = "Entradas";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 2);
                        startActivity(intent);
                        break;

                    case 2:
                        MenuOpcion = "Ensaladas";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 3);
                        startActivity(intent);
                        break;

                    case 3:
                        MenuOpcion = "Cortes";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 4);
                        startActivity(intent);
                        break;

                    case 4:
                        MenuOpcion = "Hamburguesas";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 5);
                        startActivity(intent);
                        break;

                    case 5:
                        MenuOpcion = "Especialidades";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 6);
                        startActivity(intent);
                        break;

                    case 6:
                        MenuOpcion = "Postres";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 7);
                        startActivity(intent);
                        break;

                    case 7:
                        MenuOpcion = "Bebidas";
                        intent.putExtra("Comidas", MenuOpcion);
                        intent.putExtra("Categoria", 8);
                        startActivity(intent);
                        break;
                }
            }
        });

    }

}
