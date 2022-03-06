package com.example.appcasasoniada.vendedor;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.appcasasoniada.R;
;
import com.example.appcasasoniada.common.BaseActivity;

public class DatosClientes extends BaseActivity {

    private Button btn_regresar, btn_llamar;
    Intent intent;
    TextView txt_telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dato_de_cliente);

        btn_regresar = findViewById(R.id.btn_regresar);
        btn_llamar = findViewById(R.id.btn_llamar);
        txt_telefono = findViewById(R.id.txt_telefono);

        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hola 1 !!!!!");
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                    System.out.println("Hola !!!!!");
                    ActivityCompat.requestPermissions(DatosClientes.this, new String[] { Manifest.permission.CALL_PHONE }, 0);
                }
                else {
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txt_telefono.getText().toString())));
                }
            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Listado_clientes.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + txt_telefono.getText().toString())));

            }  else {
                Toast.makeText(getApplicationContext(), "Debe de dar permiso a la app para que pueda llamar", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
