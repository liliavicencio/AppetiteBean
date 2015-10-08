package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appetite.appetite.R;

public class Noticias extends Activity implements OnClickListener {

    private Button pagoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        pagoButton = (Button) findViewById(R.id.button);
        pagoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, Pago.class);
                startActivity(intent);
                break;
        }
    }
}
