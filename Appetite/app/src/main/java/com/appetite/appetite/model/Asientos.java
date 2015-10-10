package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appetite.appetite.R;

/**
 * Created by felix on 09/10/2015.
 */
public class Asientos extends Activity implements OnClickListener {

    private Button asientosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asientos);

        asientosButton = (Button) findViewById(R.id.button2);
        asientosButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.seleccionar:
                intent = new Intent(this, Reservacion.class);
                startActivity(intent);
                break;
        }
    }
}
