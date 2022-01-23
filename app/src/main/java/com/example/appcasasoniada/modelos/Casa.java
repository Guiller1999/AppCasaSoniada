package com.example.appcasasoniada.modelos;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

public class Casa implements Serializable {
    private int id;
    private String nombre;
    private int totalHabitaciones;
    private int totalArea;
    private double valorBase;
    private int imagen;
    private ArrayList<TipoAcabados> acabados;

    public Casa(int id, String nombre, int totalHabitaciones, int totalArea, double valorBase, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.totalHabitaciones = totalHabitaciones;
        this.totalArea = totalArea;
        this.valorBase = valorBase;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTotalHabitaciones() { return totalHabitaciones; }

    public int getTotalArea() {
        return totalArea;
    }

    public double getValorBase() {
        return valorBase;
    }

    public int getImagen() {
        return imagen;
    }

    public ArrayList<TipoAcabados> getAcabados() {
        return acabados;
    }

    public void setAcabados(ArrayList<TipoAcabados> acabados) {
        this.acabados = acabados;
    }
}
