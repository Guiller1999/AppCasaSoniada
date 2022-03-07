package com.example.appcasasoniada.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcasasoniada.R;
import com.example.appcasasoniada.modelos.Proforma;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ListaInteresadosAdapter extends RecyclerView.Adapter<ListaInteresadosAdapter.ViewHolder> {

    private ArrayList<Proforma> proformas;
    private LayoutInflater inflater;
    private Context context;

    public ListaInteresadosAdapter(ArrayList<Proforma> proformas, Context context) {
        inflater = LayoutInflater.from(context);
        this.proformas = proformas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = inflater.inflate(R.layout.lista_interesados, null);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(proformas.get(position));
    }

    @Override
    public int getItemCount() {
        return proformas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCliente;
        private TextView txtCasa;
        private TextView txtAcabados;
        private TextView txtFecha;
        private TextView txtVenta;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCliente = itemView.findViewById(R.id.txt_cliente);
            txtCasa = itemView.findViewById(R.id.txt_casa_interesada);
            txtAcabados = itemView.findViewById(R.id.txt_acabados);
            txtFecha = itemView.findViewById(R.id.txt_fecha);
            txtVenta = itemView.findViewById(R.id.txt_venta);

        }

        public void bindData(Proforma item) {

            txtCliente.setText(item.getCliente());
            txtCasa.setText(item.getCasaInteresada());
            txtAcabados.setText(item.getAcabados());
            txtVenta.setText("Monto Venta: $" + String.format("%.2f", Float.parseFloat(String.valueOf(item.getMontoVenta()))));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            txtFecha.setText(dtf.format(item.getFechaProforma()));
        }
    }
}
