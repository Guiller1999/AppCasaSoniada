package com.example.appcasasoniada.clientes_conectados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appcasasoniada.R;
import com.example.appcasasoniada.common.BaseActivity;

public class Listado_clientes extends BaseActivity {
    private Button btn_vermas;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conectados);

        btn_vermas = findViewById(R.id.btn_ver_mas1);

        btn_vermas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), DatosClientes.class);
                startActivity(intent);
            }
        });
    }
}