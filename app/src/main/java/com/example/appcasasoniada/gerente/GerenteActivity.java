package com.example.appcasasoniada.gerente;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appcasasoniada.R;
import com.example.appcasasoniada.common.BaseActivity;
import com.example.appcasasoniada.adapters.ListaInteresadosAdapter;
import com.example.appcasasoniada.modelos.Proforma;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenteActivity extends BaseActivity {

    private TextView totalInteresados, totalEsmeralda, totalPlatino, totalEuropa, totalPrimavera;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerente);

        totalInteresados = findViewById(R.id.txt_total_interesados);
        totalEsmeralda = findViewById(R.id.total_esmeralda);
        totalPlatino = findViewById(R.id.total_platino);
        totalEuropa = findViewById(R.id.total_europa);
        totalPrimavera = findViewById(R.id.total_primavera);

        ArrayList<Proforma> proformas = cargarProformas();
        ListaInteresadosAdapter listaInteresadosAdapter = new ListaInteresadosAdapter(proformas, this);

        recyclerView = findViewById(R.id.recycler_interesados);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(listaInteresadosAdapter);

        colocarTotales(proformas);

    }

    private ArrayList<Proforma> cargarProformas() {
        ArrayList<Proforma> lista = new ArrayList<Proforma>();
        lista.add(new Proforma(1, "Emilia Morales", "Esmeralda", "Piso de marmol",
                LocalDateTime.now(), 15000));
        lista.add(new Proforma(2, "Engracia Palma", "Platino", "Seguridad multilock",
                LocalDateTime.now(), 20000));
        lista.add(new Proforma(3, "Juan Pelaez", "Europa", "Piso de marmol",
                LocalDateTime.now(), 15000));
        lista.add(new Proforma(4, "Manuel Ortega", "Primavera", "Grifería italiana",
                LocalDateTime.now(), 15000));
        lista.add(new Proforma(5, "Angel Ortiz", "Esmeralda", "Piso de marmol",
                LocalDateTime.now(), 15000));
        lista.add(new Proforma(6, "Silvia Perez", "Primavera", "Seguridad multilock",
                LocalDateTime.now(), 15000));

        return lista;
    }

    private void colocarTotales(ArrayList<Proforma> proformas) {
        totalInteresados.setText(String.valueOf(proformas.size()));
        int esmeralda = 0, primavera = 0, europa = 0, platino = 0;

        for (Proforma proforma: proformas) {
            if (proforma.getCasaInteresada().equals("Primavera")) primavera++;
            if(proforma.getCasaInteresada().equals("Esmeralda")) esmeralda++;
            if (proforma.getCasaInteresada().equals("Platino")) platino++;
            if(proforma.getCasaInteresada().equals("Europa")) europa++;
        }

        totalEsmeralda.setText(String.valueOf(esmeralda));
        totalEuropa.setText(String.valueOf(europa));
        totalPlatino.setText(String.valueOf(platino));
        totalPrimavera.setText(String.valueOf(primavera));

    }
}