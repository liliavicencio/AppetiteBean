package com.appetite.appetite.model;

/**
 * Created by Alex on 28/11/2015.
 */
public class Menu extends Image {

    private int id;
    private String comida;

    public Menu() {

    }

    public Menu(int id, String imagen, String comida) {
        super(imagen);
        this.id = id;
        this.setComida(comida);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }
}
