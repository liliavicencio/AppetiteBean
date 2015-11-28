package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.appetite.appetite.R;

/**
 * Created by Alex on 10/10/2015.
 */
public class Inicio extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnReservar:
                Intent intent = new Intent(this, Reservacion.class);
                startActivity(intent);
                break;
        }
    }
}
