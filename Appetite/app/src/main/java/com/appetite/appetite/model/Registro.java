package com.appetite.appetite.model;

import com.appetite.appetite.serialize.JSONSerialize;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by Alex on 27/11/2015.
 */
public class Registro  {
    @Expose
    private String numeroAsiento;
    @Expose
    private int numeroPersonas;
    @Expose
    private int hora;

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}
