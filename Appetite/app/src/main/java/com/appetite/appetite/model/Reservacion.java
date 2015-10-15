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
public class Reservacion extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservacion);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnAsiento:
                //intent = new Intent(this, Asientos.class);
                intent = new Intent(this, ImageTest.class);
                startActivity(intent);
                break;
            case R.id.btnMenuOpciones:
                intent = new Intent(this, MenuOpciones.class);
                startActivity(intent);
                break;
        }
    }
}
