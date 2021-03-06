package com.example.appcasasoniada.cliente;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Group;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcasasoniada.R;
import com.example.appcasasoniada.common.BaseActivity;
import com.example.appcasasoniada.modelos.Casa;

public class ProformaActivity extends BaseActivity {

    private TextView txtCasa, txtHabitaciones, txtArea, txtTotal;
    private ImageView imgCasa;
    private String logueado;
    private Group groupVisible, groupInvisible;
    private Casa casa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proforma);

        SharedPreferences datos = getSharedPreferences("datos", MODE_PRIVATE);
        logueado = datos.getString("usuario_rol", null);

        casa = (Casa)getIntent().getSerializableExtra("casa");
        txtCasa = findViewById(R.id.txt_telefono_c);
        txtHabitaciones = findViewById(R.id.txt_habitaciones);
        txtArea = findViewById(R.id.txt_area);
        imgCasa = findViewById(R.id.img_casa);
        txtTotal = findViewById(R.id.txt_total);

        txtCasa.setText(casa.getNombre());
        imgCasa.setBackgroundResource(casa.getImagen());
        txtHabitaciones.setText(casa.getTotalHabitaciones() + " Habitaciones");
        txtArea.setText(casa.getTotalArea() + "m2");

        if(logueado != null) {
            groupInvisible = findViewById(R.id.vista_no_login);
            groupVisible = findViewById(R.id.vista_login);

            groupInvisible.setVisibility(View.INVISIBLE);
            groupVisible.setVisibility(View.VISIBLE);

            txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(casa.getValorBase()))));
        }
        else {
            groupInvisible = findViewById(R.id.vista_login);
            groupVisible = findViewById(R.id.vista_no_login);

            groupInvisible.setVisibility(View.INVISIBLE);
            groupVisible.setVisibility(View.VISIBLE);
        }
    }

    public void onCheckboxClicked(@NonNull View view) {

        if(logueado != null)
            agregarCaracteristicas(view);
    }

    private void agregarCaracteristicas(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox)view).isChecked();
        String total = txtTotal.getText().toString();
        double totalBase = Double.parseDouble(total.substring(8));

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.piso_marmol:
                if (checked)
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase + 500.00))));
                else
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase - 500.00))));
                break;
            case R.id.griferia_italiana:
                if (checked)
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase + 500.00))));
                else
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase - 500.00))));
                break;
            case R.id.puerta:
                if (checked)
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase + 1500.00))));
                else
                    txtTotal.setText("Total: $" + String.format("%.2f", Float.parseFloat(String.valueOf(totalBase - 1500.00))));
                break;
        }
    }
}