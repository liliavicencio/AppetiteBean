package com.appetite.appetite.model;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import java.util.*;
import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ComidasAdapter;
import com.appetite.appetite.controller.ComidaOpcionesController;

public class Presentacion extends Activity implements  android.widget.CompoundButton.OnCheckedChangeListener{

    String RecibeComida;
    ListView lv;
    TextView TipoComida;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        RecibeComida = getIntent().getStringExtra("Comidas");
        TipoComida = (TextView)findViewById(R.id.TipoComida);
        TipoComida.setText(RecibeComida);
        ComidaOpcionesController MenuComidas = new ComidaOpcionesController(Presentacion.this, RecibeComida);
        MenuComidas.execute();
        lv =(ListView)findViewById(R.id.listView);


    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        int pos = lv.getPositionForView(buttonView);
        System.out.println("Pos ["+pos+"]");
        if (pos != ListView.INVALID_POSITION) {
            lv.getItemAtPosition(pos);
            lv.setSelected(isChecked);

            Toast.makeText(Presentacion.this, "Clicked on Planet:  State: is " + buttonView.getText().toString(), Toast.LENGTH_SHORT).show();

            if (isChecked== true) {

                final CharSequence[] items = {"1 Platillo", "2 Platillos", "3 platillos","4 Platillos","5 Platillos", "6 Platillos", "7 Platillos", "8 Platillos"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Cantidad de platillos: ");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Haz elegido la opcion: " + items[item] , Toast.LENGTH_SHORT);
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


