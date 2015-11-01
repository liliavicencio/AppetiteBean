package com.appetite.appetite.model;

import android.app.Activity;
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
import android.widget.Toast;

import com.appetite.appetite.R;

import java.util.Calendar;

/**
 * Created by Alex on 10/10/2015.
 */
public class Reservacion extends Activity implements OnClickListener {
    //Spinner spinner;

    static final int TIME1_DIALOG_ID=0;//timepicker
    int hour_x;//timepicker
    int minute_x;//timepicker

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservacion);
        //spinner = (Spinner) findViewById(R.id.spinnerSuc);
        showTimePickerDialog();//timepicker
        setCurrentDateOnView();
        showDatePickerDialog();
        counter = 0;
        add = (Button) findViewById(R.id.btnSumar);
        sub = (Button) findViewById(R.id.btnRestar);
        final TextView textViewResult=(TextView)findViewById(R.id.total_personas);

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

    //Time Picker 1
    public void showTimePickerDialog(){
       Button btn1 = (Button) findViewById(R.id.btnTimerEntrada);
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(TIME1_DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case TIME1_DIALOG_ID:
            return new TimePickerDialog(Reservacion.this, eTimePickerListner, hour_x, minute_x,false);

            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);

            /*case TIME2_DIALOG_ID:
                return  new TimePickerDialog(Reservacion.this,sTimePickerListner, hour_y, minute_y, false);*/
        }

        return null;
    }


    protected TimePickerDialog.OnTimeSetListener eTimePickerListner = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour_x = hourOfDay;
            minute_x = minute;
            Toast.makeText(Reservacion.this, "Hora: " + hour_x + " Minutos: " + minute_x, Toast.LENGTH_LONG).show();
        }
    };


    //TIME PICKER ENDS
    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            disp_Fecha.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };


    /*void loadSpinner() {
        SucursalController suc = new SucursalController();
        String nombre;
        nombre = suc.doInBackground("http://appetite.esy.es/File/SpinnerSucursal.php","sucursal_array","nombre");

        dataAdapter.setDropDownViewResource(R.layout.reservacion);
        spinner.setAdapter(dataAdapter);

    }*/
}


