package com.appetite.appetite.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.appetite.appetite.R;
import com.appetite.appetite.controller.AsientosController;
import com.appetite.appetite.serialize.JSONSerialize;

/*
import com.appetite.appetite.R;
import com.appetite.appetite.adapter.ListViewAdapter;
import com.appetite.appetite.controller.MenuOpcionesController;*/

public class AsientosModel extends Activity {

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asientos);

        Bundle bolsa = getIntent().getExtras();

        String time = bolsa.getString("time");
        String time2 = bolsa.getString("time2");
        String date = bolsa.getString("date");
        /*
        JSONSerialize<Registro> serialize = new JSONSerialize<Registro>(Registro.class);
        Registro registro = serialize.getSerialization(this,"registro");

        String time = registro.getTime();
        String time2 = registro.getTime2();
        String date = registro.getDate();

        System.out.println("Time:" + time);
        System.out.println("Time2:" + time2);
        System.out.println("Date:" + date);*/

        /*String time = "15:00:00";
        String time2 = "17:00:00";
        String date = "2015-10-31";*/

        AsientosController ac = new AsientosController(AsientosModel.this, time, date, time2);

        ac.execute();
    }

    public void onClick(View v) {

        JSONSerialize<Registro> serialize = new JSONSerialize<Registro>(Registro.class);
        Registro registro = serialize.getSerialization(this,"registro");

        switch (v.getId()){
            case R.id.button1:
                Intent int1 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa = new Bundle();
                bolsa.putString("asiento", "1");
                int1.putExtras(bolsa);*/
                registro.setAsiento("1");
                serialize.setSerialization(this,registro,"registro");

                v.getContext().startActivity(int1);
                break;

            case R.id.button2:
                Intent int2 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa2 = new Bundle();
                bolsa2.putString("asiento", "2");
                int2.putExtras(bolsa2);*/
                registro.setAsiento("2");
                serialize.setSerialization(this,registro,"registro");

                v.getContext().startActivity(int2);
                break;

            case R.id.button3:
                Intent int3 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa3 = new Bundle();
                bolsa3.putString("asiento", "3");
                int3.putExtras(bolsa3);*/
                registro.setAsiento("3");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int3);
                break;


            case R.id.button4:
                Intent int4 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa4 = new Bundle();
                bolsa4.putString("asiento", "4");
                int4.putExtras(bolsa4);*/
                registro.setAsiento("4");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int4);
                break;

            case R.id.button5:
                Intent int5 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa5 = new Bundle();
                bolsa5.putString("asiento", "5");
                int5.putExtras(bolsa5);*/
                registro.setAsiento("5");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int5);
                break;

            case R.id.button6:
                Intent int6 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa6 = new Bundle();
                bolsa6.putString("asiento", "6");
                int6.putExtras(bolsa6);*/
                registro.setAsiento("6");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int6);
                break;

            case R.id.button7:
                Intent int7 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa7 = new Bundle();
                bolsa7.putString("asiento", "7");
                int7.putExtras(bolsa7);*/
                registro.setAsiento("7");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int7);
                break;

            case R.id.button8:
                Intent int8 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa8 = new Bundle();
                bolsa8.putString("asiento", "8");
                int8.putExtras(bolsa8);*/
                registro.setAsiento("8");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int8);
                break;

            case R.id.button9:
                Intent int9 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa9 = new Bundle();
                bolsa9.putString("asiento", "9");
                int9.putExtras(bolsa9);*/
                registro.setAsiento("9");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int9);
                break;

            case R.id.button10:
                Intent int10 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa10 = new Bundle();
                bolsa10.putString("asiento", "10");
                int10.putExtras(bolsa10);*/
                registro.setAsiento("10");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int10);
                break;

            case R.id.button11:
                Intent int11 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa11 = new Bundle();
                bolsa11.putString("asiento", "11");
                int11.putExtras(bolsa11);*/
                registro.setAsiento("11");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int11);
                break;

            case R.id.button12:
                Intent int12 = new Intent(v.getContext(), MenuOpciones.class);
                /*Bundle bolsa12 = new Bundle();
                bolsa12.putString("asiento", "12");
                int12.putExtras(bolsa12);*/
                registro.setAsiento("12");
                serialize.setSerialization(this,registro,"registro");
                v.getContext().startActivity(int12);
                break;
        }
    }
}