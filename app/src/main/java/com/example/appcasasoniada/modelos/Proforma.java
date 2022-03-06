package com.example.appcasasoniada.modelos;

import java.time.LocalDateTime;

public class Proforma {

    private int id;
    private String cliente;
    private String casaInteresada;
    private String acabados;
    private LocalDateTime fechaProforma;
    private double montoVenta;

    public Proforma(int id, String cliente, String casaInteresada,
                    String acabados, LocalDateTime fechaProforma, double montoVenta) {
        this.id = id;
        this.cliente = cliente;
        this.casaInteresada = casaInteresada;
        this.acabados = acabados;
        this.fechaProforma = fechaProforma;
        this.montoVenta = montoVenta;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getCasaInteresada() {
        return casaInteresada;
    }

    public String getAcabados() {
        return acabados;
    }

    public LocalDateTime getFechaProforma() {
        return fechaProforma;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

}
