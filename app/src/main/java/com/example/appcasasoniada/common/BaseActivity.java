package com.example.appcasasoniada.common;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appcasasoniada.MainActivity;
import com.example.appcasasoniada.R;

public class BaseActivity extends AppCompatActivity {

    private boolean logueado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences datos = getSharedPreferences("datos", MODE_PRIVATE);
        logueado = datos.getBoolean("logeado", false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        if(logueado != false) {
            menu.setGroupVisible(R.id.menu_nologin, false);
            menu.setGroupVisible(R.id.menu_login, true);
        }
        else {
            menu.setGroupVisible(R.id.menu_nologin, true);
            menu.setGroupVisible(R.id.menu_login, false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.iniciar_sesion:
                Toast.makeText(getApplicationContext(), "Iniciar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.registrar:
                Toast.makeText(getApplicationContext(), "Registrar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.home:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.salir:
                Toast.makeText(getApplicationContext(), "Salir", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
