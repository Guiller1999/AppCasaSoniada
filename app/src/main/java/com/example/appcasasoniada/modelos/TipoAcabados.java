package com.example.appcasasoniada.modelos;

public class TipoAcabados {

    private String descripcion;
    private double precio;

    public TipoAcabados(String descripcion, double precio) {
        this.descripcion = descripcion;
        this. precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

}
