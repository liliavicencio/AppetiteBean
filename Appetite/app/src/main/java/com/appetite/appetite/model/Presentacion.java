package com.appetite.appetite.model;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appetite.appetite.R;
import com.appetite.appetite.controller.ComidaOpcionesController;
import com.appetite.appetite.serialize.JSONSerialize;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Presentacion extends Activity implements  android.widget.CompoundButton.OnCheckedChangeListener{

    String RecibeComida;
    ListView listView;
    TextView TipoComida;
    String CATEGORIA;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        RecibeComida = getIntent().getStringExtra("Comidas");
        CATEGORIA = getIntent().getStringExtra("Categoria");
        TipoComida = (TextView)findViewById(R.id.TipoComida);
        TipoComida.setText(RecibeComida);
        ComidaOpcionesController MenuComidas
                = new ComidaOpcionesController(Presentacion.this, RecibeComida, CATEGORIA);
        MenuComidas.execute();
        listView =(ListView)findViewById(R.id.listView);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int pos = listView.getPositionForView(buttonView);

        if (pos != ListView.INVALID_POSITION) {
            listView.getItemAtPosition(pos);
            listView.setSelected(isChecked);

            Toast.makeText(Presentacion.this, "Clicked on Planet:  State: is " + buttonView.getText().toString(), Toast.LENGTH_SHORT).show();

            if (isChecked== true) {

                final CharSequence[] items = {"1 Platillo", "2 Platillos", "3 platillos","4 Platillos","5 Platillos", "6 Platillos", "7 Platillos", "8 Platillos"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Cantidad de platillos: ");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Haz elegido la opcion: " + items[item], Toast.LENGTH_SHORT);
                        toast.show();
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }

    }

}


