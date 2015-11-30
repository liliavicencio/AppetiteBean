package com.appetite.appetite.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.appetite.appetite.R;

import com.appetite.appetite.connection.ServerConnection;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by felix on 28/10/2015.
 */
public class AsientosService extends AsyncTask<String, String, String> {

    private final String URL_ = "http://appetite.esy.es/File/AsientosController.php";
    private final String TAG_ARRAY_ASIENTO_ = "asientos_array";
    private final String TAG_ASIENTO_ = "asientoId";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    private ArrayList<String> asientoList = new ArrayList<>();

    private ProgressDialog pDialog;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;

    int asiento1 = 0;
    int asiento2 = 0;
    int asiento3 = 0;
    int asiento4 = 0;
    int asiento5 = 0;
    int asiento6 = 0;
    int asiento7 = 0;
    int asiento8 = 0;
    int asiento9 = 0;
    int asiento10 = 0;
    int asiento11 = 0;
    int asiento12 = 0;

    Activity activity;

    String time;
    String time2;
    String date;

    public AsientosService(Activity activity, String time, String date, String time2){
        this.activity = activity;
        this.time = time;
        this.date = date;
        this.time2 = time2;
    }

    /*@Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Cargando asientos...");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }*/

    protected String doInBackground(String... args) {
        StringBuilder params = new StringBuilder();
        ServerConnection serverConnection = new ServerConnection();
        JSONObject json;
        int success;
        System.out.println(date);
        System.out.println(time);
        System.out.println(time2);

        params.append("fecha").append("=").append(date)
                .append("&").append("horaEntrada").append("=").append(time)
                .append("&").append("horaSalida").append("=").append(time2);

        json = serverConnection.makeHttpRequestPost(URL_, params.toString());

        JSONArray asiento_ = null;
        JSONObject Aasiento_;

        try {
            asiento_=json.getJSONArray(TAG_ARRAY_ASIENTO_);

            for (int cont=0; cont < asiento_.length(); cont++){
                Aasiento_=asiento_.getJSONObject(cont);

                switch (Aasiento_.getInt(TAG_ASIENTO_)){
                    case 1:
                        asiento1 = 1;
                        break;
                    case 2:
                        asiento2 = 1;
                        break;
                    case 3:
                        asiento3 = 1;
                        break;
                    case 4:
                        asiento4 = 1;
                        break;
                    case 5:
                        asiento5 = 1;
                        break;
                    case 6:
                        asiento6 = 1;
                        break;
                    case 7:
                        asiento7 = 1;
                        break;
                    case 8:
                        asiento8 = 1;
                        break;
                    case 9:
                        asiento9 = 1;
                        break;
                    case 10:
                        asiento10 = 1;
                        break;
                    case 11:
                        asiento11 = 1;
                        break;
                    case 12:
                        asiento12 = 1;
                        break;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        btn1 = (Button) activity.findViewById(R.id.button1);
        btn2 = (Button) activity.findViewById(R.id.button2);
        btn3 = (Button) activity.findViewById(R.id.button3);
        btn4 = (Button) activity.findViewById(R.id.button4);
        btn5 = (Button) activity.findViewById(R.id.button5);
        btn6 = (Button) activity.findViewById(R.id.button6);
        btn7 = (Button) activity.findViewById(R.id.button7);
        btn8 = (Button) activity.findViewById(R.id.button8);
        btn9 = (Button) activity.findViewById(R.id.button9);
        btn10 = (Button) activity.findViewById(R.id.button10);
        btn11 = (Button) activity.findViewById(R.id.button11);
        btn12 = (Button) activity.findViewById(R.id.button12);

        if(asiento1 == 1){
            btn1.setEnabled(false);
            btn1.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento2 == 1){
            btn2.setEnabled(false);
            btn2.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento3 == 1){
            btn3.setEnabled(false);
            btn3.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento4 == 1){
            btn4.setEnabled(false);
            btn4.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento5 == 1){
            btn5.setEnabled(false);
            btn5.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento6 == 1){
            btn6.setEnabled(false);
            btn6.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento7 == 1){
            btn7.setEnabled(false);
            btn7.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento8 == 1){
            btn8.setEnabled(false);
            btn8.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento9 == 1){
            btn9.setEnabled(false);
            btn9.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento10 == 1){
            btn10.setEnabled(false);
            btn10.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento11 == 1){
            btn11.setEnabled(false);
            btn11.setBackgroundColor(Color.parseColor("#ca4236"));
        }

        if(asiento12 == 1){
            btn12.setEnabled(false);
            btn12.setBackgroundColor(Color.parseColor("#ca4236"));
        }
    }
}