package com.appetite.appetite.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.appetite.appetite.R;
import com.appetite.appetite.service.ComidaOpcionesService;

public class PresentacionController extends Activity implements  OnCheckedChangeListener{

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
        ComidaOpcionesService MenuComidas
                = new ComidaOpcionesService(PresentacionController.this, RecibeComida, CATEGORIA);
        MenuComidas.execute();
        listView =(ListView)findViewById(R.id.listView);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int position = listView.getPositionForView(buttonView);

        if (position != ListView.INVALID_POSITION) {
            listView.getItemAtPosition(position);
            listView.setSelected(isChecked);

            Toast.makeText(PresentacionController.this, "Clicked on Planet:  State: is " + buttonView.getText().toString(), Toast.LENGTH_SHORT).show();

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


