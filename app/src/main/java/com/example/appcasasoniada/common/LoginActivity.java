package com.example.appcasasoniada.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appcasasoniada.MainActivity;
import com.example.appcasasoniada.R;
import com.example.appcasasoniada.modelos.TipoUsuario;
import com.example.appcasasoniada.modelos.Usuario;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity {

    private ArrayList<Usuario> usuarios;
    private Button btnIniciar, btnRegistrar;
    private TextInputLayout txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cargarUsuarios();
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        btnIniciar = findViewById(R.id.btn_iniciar);
        btnRegistrar = findViewById(R.id.btn_registrar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = txtEmail.getEditText().getText().toString();
                String contraseña = txtPassword.getEditText().getText().toString();
                SharedPreferences preferences = getSharedPreferences("datos", MODE_PRIVATE);

                Usuario usuario = buscarUsuario(correo, contraseña);

                if(usuario != null) {

                    SharedPreferences.Editor editor = preferences.edit();
                    Gson gson = new Gson();
                    editor.putString("usuario_rol", gson.toJson(usuario.getTipoUsuario()));
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Error. Credenciales de acceso erróneas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
            }
        });

    }

    private void cargarUsuarios() {
        usuarios = new ArrayList<Usuario>();

        usuarios.add(new Usuario(1,"Ángel", "Ortiz Valverde", "angel_ortiz@hotmail.com",
                "angel123", TipoUsuario.CLIENTE));
        usuarios.add(new Usuario(2,"Carolina", "Pérez Arteaga", "carolina_perez@hotmail.com",
                "carolina123", TipoUsuario.VENDEDOR));
        usuarios.add(new Usuario(3,"Carlos", "Rodríguez Peralta", "carlos_2611@hotmail.com",
                "carlos123", TipoUsuario.GERENTE));
    }

    private Usuario buscarUsuario(String correo, String contraseña) {

        for (Usuario usuario: usuarios) {
            if(usuario.getEmail().equals(correo) && usuario.getPassword().equals(contraseña))
                return usuario;
        }

        return null;
    }
}