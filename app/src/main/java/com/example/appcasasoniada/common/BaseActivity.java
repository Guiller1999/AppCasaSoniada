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
import com.example.appcasasoniada.clientes_conectados.Listado_clientes;
import com.example.appcasasoniada.modelos.TipoUsuario;
import com.example.appcasasoniada.modelos.Usuario;
import com.google.gson.Gson;

public class BaseActivity extends AppCompatActivity {

    private boolean logueado;
    private TipoUsuario usuario;
    private SharedPreferences datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        datos = getSharedPreferences("datos", MODE_PRIVATE);
        Gson gson = new Gson();
        String usuario_rol = datos.getString("usuario_rol", null);
        usuario = null;

        if(usuario_rol != null)
            usuario = gson.fromJson(usuario_rol, TipoUsuario.class);

        logueado = datos.getBoolean("logeado", false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        if(usuario == null) {
            menu.setGroupVisible(R.id.menu_nologin, true);
            menu.setGroupVisible(R.id.menu_login, false);
            menu.setGroupVisible(R.id.menu_cliente, false);
            menu.setGroupVisible(R.id.menu_vendedor, false);
        }
        else if(usuario == TipoUsuario.CLIENTE) {
            menu.setGroupVisible(R.id.menu_cliente, true);
            menu.setGroupVisible(R.id.menu_nologin, false);
            menu.setGroupVisible(R.id.menu_login, false);
            menu.setGroupVisible(R.id.menu_vendedor, false);
        }

        else if(usuario == TipoUsuario.VENDEDOR) {
            menu.setGroupVisible(R.id.menu_cliente, false);
            menu.setGroupVisible(R.id.menu_nologin, false);
            menu.setGroupVisible(R.id.menu_vendedor, true);
            menu.setGroupVisible(R.id.menu_login, false);
        }
        else {
            menu.setGroupVisible(R.id.menu_login, true);
            menu.setGroupVisible(R.id.menu_nologin, false);
            menu.setGroupVisible(R.id.menu_cliente, false);
            menu.setGroupVisible(R.id.menu_vendedor, false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case R.id.iniciar_sesion:
                intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.registrar:
                intent = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
                return true;
            case R.id.home:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.listado_cliente:
                intent = new Intent(getApplicationContext(), Listado_clientes.class);
                startActivity(intent);
                return true;
            case R.id.salir:
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("usuario_rol", null);
                editor.commit();

                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
