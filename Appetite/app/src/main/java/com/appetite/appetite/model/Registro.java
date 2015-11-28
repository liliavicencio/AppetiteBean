package com.appetite.appetite.model;

import com.appetite.appetite.serialize.JSONSerialize;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Alex on 27/11/2015.
 */
public class Registro  {
    @Expose
    private String time;
    @Expose
    private String time2;
    @Expose
    private String date;
    @Expose
    private String asiento;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
}
