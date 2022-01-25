package com.example.appcasasoniada;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import com.example.appcasasoniada.cliente.ListaCasaAdapter;
import com.example.appcasasoniada.common.BaseActivity;
import com.example.appcasasoniada.modelos.Casa;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Casa> casas = cargarCasas();
        ListaCasaAdapter listaCasaAdapter = new ListaCasaAdapter(casas, this);

        recyclerView = findViewById(R.id.recycler_datos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listaCasaAdapter);
    }


    private ArrayList<Casa> cargarCasas() {
        ArrayList<Casa> lista = new ArrayList<Casa>();
        lista.add(new Casa(1, "Casa Esmeralda", 2, 85,
                12000, R.drawable.casa1));
        lista.add(new Casa(2, "Casa Platino", 3, 115,
                20000, R.drawable.casa2));
        lista.add(new Casa(3, "Casa Europa", 3, 90,
                16000, R.drawable.casa3));
        lista.add(new Casa(4, "Casa Primavera", 4, 140,
                23000, R.drawable.casa4));
        return lista;
    }


}