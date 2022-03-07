package com.example.appcasasoniada.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseConfig.DB_NAME, null, DatabaseConfig.version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Creamos la tabla TipoUsuario
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_TIPO_USUARIO);
        // Creamos la tabla Usuario
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_USUARIO);
        // Creamos la tabla Casas
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_CASA);
        // Creamos la tabla Acabados
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_ACABADOS);
        // Creamos la tabla Proforma
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_PROFORMA);
        // Creamos la tabla ProformaAcabados
        sqLiteDatabase.execSQL(DatabaseConfig.TABLE_PROFORMA_ACABADOS);

        boolean result = isData(sqLiteDatabase);
        if(result == false) {
            DatabaseConfig.insertDataTipoUsuario(sqLiteDatabase);
            DatabaseConfig.insertDataUsuarios(sqLiteDatabase);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private boolean isData(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TIPO_USUARIO", new String []{});

        if(cursor.getCount() != 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
