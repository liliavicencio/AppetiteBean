package com.appetite.appetite.model;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ListViewAdapter;
import com.appetite.appetite.controller.MenuOpcionesController;

public class MenuOpciones extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_opciones);
        MenuOpcionesController imageController = new MenuOpcionesController(MenuOpciones.this);
        imageController.execute();
    }
}
