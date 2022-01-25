package com.example.appcasasoniada.clientes_conectados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.appcasasoniada.R;
;
import com.example.appcasasoniada.common.BaseActivity;

public class DatosClientes extends BaseActivity {

    private Button btn_regresar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dato_de_cliente);
        btn_regresar = findViewById(R.id.btn_regresar);

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Listado_clientes.class);
                startActivity(intent);
            }
        });
    }
}
