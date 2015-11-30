package com.appetite.appetite.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.appetite.appetite.R;

/**
 * Created by Alex on 05/10/2015.
 */
public class PagoController extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pago);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.confirm_pay_button:
                Intent intent = new Intent(this, ConfimacionPagoController.class);
                startActivity(intent);
                break;
            case R.id.paypal_radio:
            case R.id.visa_radio:
            case R.id.master_radio:
                if (((RadioButton) v).isChecked()) {
                    ((RadioButton) v).setChecked(true);
                }
                break;
        }
    }

}
