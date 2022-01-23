package com.example.appcasasoniada.modelos;

import java.util.Date;

public class Usuario {

    private int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String password;
    private Date fecha_inicio_sesion;
    private TipoUsuario tipoUsuario;

    public Usuario(int id, String nombre, String apellidos, String email, String password, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getFechaInicioSesion() {
        return fecha_inicio_sesion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
