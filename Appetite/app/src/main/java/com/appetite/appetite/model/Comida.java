package com.appetite.appetite.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Alex on 27/11/2015.
 */
public class Comida extends Image{
    @Expose
    private int id;
    @Expose
    private int posicionMenu;
    @Expose
    private String categoria;
    private String descripcion;
    @Expose
    private String precio;
    @Expose
    private String cantidad;
    private boolean seleccionado;

    public Comida() {

    }

    public Comida(int id, int posicionMenu, String categoria, String precio, String cantidad,
                  String imagen) {
        super(imagen);
        this.setId(id);
        this.setPosicionMenu(posicionMenu);
        this.setCategoria(categoria);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosicionMenu() {
        return posicionMenu;
    }

    public void setPosicionMenu(int posicionMenu) {
        this.posicionMenu = posicionMenu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
