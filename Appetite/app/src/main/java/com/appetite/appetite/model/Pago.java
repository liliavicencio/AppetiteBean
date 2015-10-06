package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.appetite.appetite.R;
import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalInvoiceData;
import com.paypal.android.MEP.PayPalPayment;

import java.math.BigDecimal;

/**
 * Created by Alex on 05/10/2015.
 */
public class Pago extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pago);

        invokeSimplePayment();
    }

    private void invokeSimplePayment() {
        try {

            PayPalPayment newPayment = new PayPalPayment();
            newPayment.setSubtotal(BigDecimal.valueOf(10));
            newPayment.setCurrencyType("USD");
            newPayment.setRecipient("my@email.com");
            newPayment.setMerchantName("My Company");

            PayPal pp = PayPal.getInstance();

            if (pp == null) {
                pp = PayPal.initWithAppID(this, "APP-80W284485P519543T", PayPal.ENV_SANDBOX);
            }

            Intent paypalIntent = pp.checkout(newPayment, this);
            this.startActivityForResult(paypalIntent, 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
