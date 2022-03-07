package com.example.appcasasoniada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcasasoniada.gerente.GerenteActivity;
import com.example.appcasasoniada.modelos.TipoUsuario;
import com.example.appcasasoniada.vendedor.Listado_clientes;
import com.google.gson.Gson;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation topAnim, bottomAnim;
    private ImageView imgLogo;
    private TextView slogan;
    private static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Animations
        topAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_animation);

        // Hooks
        imgLogo = findViewById(R.id.imgLogo_white);
        slogan = findViewById(R.id.slogan);

        imgLogo.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences datos = getSharedPreferences("datos", MODE_PRIVATE);
                Gson gson = new Gson();
                String usuario_rol = datos.getString("usuario_rol", null);
                TipoUsuario usuario = null;

                if(usuario_rol == null) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    usuario = gson.fromJson(usuario_rol, TipoUsuario.class);
                    cargarVentanas(usuario);
                }
            }
        }, SPLASH_SCREEN);
    }

    public void cargarVentanas(TipoUsuario usuario) {
        Intent intent;
        switch (usuario) {
            case CLIENTE:
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case VENDEDOR:
                intent = new Intent(getApplicationContext(), Listado_clientes.class);
                startActivity(intent);
                finish();
                break;
            case GERENTE:
                intent = new Intent(getApplicationContext(), GerenteActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}