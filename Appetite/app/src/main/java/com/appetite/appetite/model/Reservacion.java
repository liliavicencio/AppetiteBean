package com.appetite.appetite.model;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.appetite.appetite.R;

import java.util.Calendar;

/**
 * Created by Alex on 10/10/2015.
 */
public class Reservacion extends Activity implements OnClickListener {
    //Spinner spinner;

    static final int TIME_DIALOG_ID1=1;//timepicker
    static final int TIME_DIALOG_ID2=2;//timepicker
    int hour_x;//timepicker
    int minute_x;//timepicker
    int hour_y;
    int minute_y;
    int actual;
    public TextView dispHE;
    public TextView dispHS;

    /*Date Picker*/
    private TextView disp_Fecha;
    private DatePicker dpResult;
    static final int DATE_DIALOG_ID = 999;
    private int year;
    private int month;
    private int day;

    //Personas
    int counter;
    Button add, sub;
    TextView resultado;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        try{
            Bundle bolsa = getIntent().getExtras();
            String asiento =  bolsa.getString("asiento");
            System.out.println("FINAL: " + asiento);
        }
        catch(Exception e){
            System.out.println(e);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservacion);
        //spinner = (Spinner) findViewById(R.id.spinnerSuc);
        showTimePickerDialog();
        setCurrentDateOnView();
        showDatePickerDialog();
        counter = 0;
        add = (Button) findViewById(R.id.btnSumar);
        sub = (Button) findViewById(R.id.btnRestar);
        final TextView textViewResult=(TextView)findViewById(R.id.total_personas);
        dispHE = (TextView)findViewById(R.id.dispHE);
        dispHS = (TextView)findViewById(R.id.dispHS);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds 1 to the counter
                counter = counter + 1;
                textViewResult.setText(String.valueOf(counter));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Subtract 1 from counter
                counter = counter - 1;
                if(counter<=0) {
                    counter = 0;
                }
                textViewResult.setText(String.valueOf(counter));
            }
        });
    }


    @Override
    public void onClick(View v) {

        String hours = String.valueOf(hour_x);
        String minutes = String.valueOf(minute_x);

        String hours2 = String.valueOf(hour_y);
        String minutes2 = String.valueOf(minute_y);

        String year_ = String.valueOf(year);
        String month_ = String.valueOf(month);
        String day_ = String.valueOf(day);

        String time = hours + ":" + minutes + ":00";
        String time2 = hours2 + ":" + minutes2 + ":00";

        String date = year + "-" + month + "-" + day;

        Intent intent;
        switch (v.getId()) {
            case R.id.btnAsiento:
                intent = new Intent(this, AsientosModel.class);

                Bundle bolsa = new Bundle();
                bolsa.putString("time",time);
                bolsa.putString("time2",time2);
                bolsa.putString("date",date);
                intent.putExtras(bolsa);

                startActivity(intent);
                break;
            case R.id.btnMenuOpciones:
                intent = new Intent(this, MenuOpciones.class);
                startActivity(intent);
                break;

        }
    }

    public void showDatePickerDialog() {

        Button btnChangeDate = (Button) findViewById(R.id.btn_cambioFecha);

        btnChangeDate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);

            }

        });

    }

    public void setCurrentDateOnView() {

        disp_Fecha = (TextView) findViewById(R.id.dispFecha);
        dpResult = (DatePicker) findViewById(R.id.fecha_picker);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        disp_Fecha.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));

        // set current date into datepicker
        dpResult.init(year, month, day, null);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth + 1;
            day = selectedDay;

            // set selected date into textview
            disp_Fecha.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };

    //Time Picker 1
    public void showTimePickerDialog(){
        Button btn1 = (Button) findViewById(R.id.btnTimerEntrada);
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME_DIALOG_ID1);
                    }
                }
        );
        Button btn2 = (Button) findViewById(R.id.btnTimerSalida);
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME_DIALOG_ID2);
                    }
                }
        );
    }

    AlertDialog myDialog = null;

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case TIME_DIALOG_ID1:
                myDialog = new TimePickerDialog(Reservacion.this, eTimePickerListner, hour_x, minute_x,false);
                actual = TIME_DIALOG_ID1;
                break;
            case DATE_DIALOG_ID:
                myDialog = new DatePickerDialog(this, datePickerListener, year, month,day);
                break;
            case TIME_DIALOG_ID2:
                myDialog = new TimePickerDialog(Reservacion.this, eTimePickerListner, hour_y, minute_y,false);
                actual = TIME_DIALOG_ID2;
                break;
              }

        return myDialog;
    }


    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }

    protected TimePickerDialog.OnTimeSetListener eTimePickerListner = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            if(actual == TIME_DIALOG_ID1){
                hour_x = hourOfDay;
                minute_x = minute;
                dispHE.setText(new StringBuilder().append(pad(hour_x)).append(":").append(pad(minute_x)));
            }

            if(actual == TIME_DIALOG_ID2){
                hour_y = hourOfDay;
                minute_y = minute;
                dispHS.setText(new StringBuilder().append(pad(hour_y)).append(":").append(pad(minute_y)));
            }
        }
    };


    //TIME PICKER ENDS

/*

    void loadSpinner() {
        SucursalController suc = new SucursalController();
        String nombre;
        nombre = suc.doInBackground("http://appetite.esy.es/File/SpinnerSucursal.php","sucursal_array","nombre");

        dataAdapter.setDropDownViewResource(R.layout.reservacion);
        spinner.setAdapter(dataAdapter);

    }*/
}


