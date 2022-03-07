package com.example.appcasasoniada.database;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseConfig {
    public static final String DB_NAME = "DB_CasaSoniada";
    public static final int version = 1;

    // Tablas de la Base de Datos
    // Tabla Tipo de Usuario
    public static final String TABLE_TIPO_USUARIO = "CREATE TABLE IF NOT EXISTS TIPO_USUARIO" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Descripcion TEXT NOT NULL)";

    // Tabla de Usuario
    public static final String TABLE_USUARIO = "CREATE TABLE IF NOT EXISTS USUARIO" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Apellidos TEXT NOT NULL, " +
            "Telefono TEXT NOT NULL, Direccion TEXT NOT NULL, Correo TEXT NOT NULL, " +
            "Contraseña TEXT NOT NULL, Fecha_Hora_Conexion TEXT, Id_TipoUsuario INTEGER NOT NULL," +
            "FOREIGN KEY(Id_TipoUsuario) REFERENCES TIPO_USUARIO(Id))";

    // Tabla de Casas
    public static final String TABLE_CASA = "CREATE TABLE IF NOT EXISTS CASA" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Habitaciones TEXT NOT NULL, " +
            "Area INTEGER NOT NULL, ValorBase REAL NOT NULL, Url_Imagen TEXT NOT NULL)";

    // Tabla de Acabados
    public static final String TABLE_ACABADOS = "CREATE TABLE IF NOT EXISTS ACABADOS" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Descripcion TEXT NOT NULL, " +
            "Precio REAL NOT NULL)";

    // Tabla Proforma
    public static final String TABLE_PROFORMA = "CREATE TABLE IF NOT EXISTS PROFORMA" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Id_Casa INTEGER NOT NULL, Id_Usuario INTEGER NOT NULL, " +
            "Precio_Total REAL NOT NULL, Fecha TEXT NOT NULL, FOREIGN KEY(Id_Casa) REFERENCES Casa(Id)," +
            "FOREIGN KEY(Id_Usuario) REFERENCES USUARIO(Id))";

    // Tabla Proforma_Acabados
    public static final String TABLE_PROFORMA_ACABADOS = "CREATE TABLE IF NOT EXISTS PROFORMA_ACABADOS" +
            "(Id INTEGER PRIMARY KEY AUTOINCREMENT, Id_Proforma INTEGER NOT NULL, Id_Acabados INTEGER NOT NULL, " +
            "FOREIGN KEY(Id_Proforma) REFERENCES PROFORMA(Id), " +
            "FOREIGN KEY(Id_Acabados) REFERENCES ACABADOS(Id))";


    // Insertamos datos preestablecidos en la tabla TipoUsuario
    public static void insertDataTipoUsuario(SQLiteDatabase sqLiteDatabase) {

        ContentValues dato1 = new ContentValues();
        ContentValues dato2 = new ContentValues();
        ContentValues dato3 = new ContentValues();

        try {
            dato1.put("Descripcion", "Cliente");
            dato2.put("Descripcion", "Vendedor");
            dato3.put("Descripcion", "Gerente");
            sqLiteDatabase.insert("TIPO_USUARIO", null, dato1);
            sqLiteDatabase.insert("TIPO_USUARIO", null, dato2);
            sqLiteDatabase.insert("TIPO_USUARIO", null, dato3);
        }
        catch (SQLException exception) {
            Log.e("Error Insertar: ", exception.getMessage());
        }
    }

    public static void insertDataUsuarios(SQLiteDatabase sqLiteDatabase) {
        ContentValues dato1 = new ContentValues();
        ContentValues dato2 = new ContentValues();
        ContentValues dato3 = new ContentValues();

        try {
            dato1.put("Nombre", "Ángel");
            dato1.put("Apellidos", "Ortiz Valverde");
            dato1.put("Telefono", "0912312398");
            dato1.put("Direccion", "Calle Plaza Luis, 939, 3° E");
            dato1.put("Correo", "angel_ortiz@hotmail.com");
            dato1.put("Contraseña", "angel123");
            dato1.put("Id_TipoUsuario", 1);

            dato2.put("Nombre", "Carolina");
            dato2.put("Apellidos", "Pérez Arteaga");
            dato2.put("Telefono", "0912312331");
            dato2.put("Direccion", "Calle Plaza Luis, 939, 3° E");
            dato2.put("Correo", "carolina_perez@hotmail.com");
            dato2.put("Contraseña", "carolina123");
            dato2.put("Id_TipoUsuario", 2);

            dato3.put("Nombre", "Carlos");
            dato3.put("Apellidos", "Rodríguez Peralta");
            dato3.put("Telefono", "095345135435");
            dato3.put("Direccion", "Calle Plaza Luis, 939, 3° E");
            dato3.put("Correo", "carlos_2611@hotmail.com");
            dato3.put("Contraseña", "carlos123");
            dato3.put("Id_TipoUsuario", 3);

            sqLiteDatabase.insert("USUARIO", null, dato1);
            sqLiteDatabase.insert("USUARIO", null, dato2);
            sqLiteDatabase.insert("USUARIO", null, dato3);
        }
        catch (SQLException exception) {
            Log.e("Error Insertar: ", exception.getMessage());
        }
    }
}
