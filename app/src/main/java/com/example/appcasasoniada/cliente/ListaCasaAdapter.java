package com.example.appcasasoniada.cliente;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appcasasoniada.R;
import com.example.appcasasoniada.modelos.Casa;

import java.util.ArrayList;

public class ListaCasaAdapter extends RecyclerView.Adapter<ListaCasaAdapter.ViewHolder> {

    private ArrayList<Casa> casas;
    private LayoutInflater inflater;
    private Context context;

    public ListaCasaAdapter(ArrayList<Casa> casas, Context context) {
        inflater = LayoutInflater.from(context);
        this.casas = casas;
        this.context = context;
    }

    @NonNull
    @Override
    public ListaCasaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = inflater.inflate(R.layout.lista_casas, null);
        return new ListaCasaAdapter.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCasaAdapter.ViewHolder holder, int position) {
        holder.bindData(casas.get(position));
    }

    @Override
    public int getItemCount() {
        return casas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView txtCasa;
        private TextView txtHabitaciones;
        private TextView txtArea;
        private Button btn_proforma;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.img_casa);
            txtCasa = itemView.findViewById(R.id.txt_telefono_c);
            txtHabitaciones = itemView.findViewById(R.id.txt_habitaciones);
            txtArea = itemView.findViewById(R.id.txt_area);
            btn_proforma = itemView.findViewById(R.id.btn_ver_mas);

        }

        public void bindData(Casa item) {
            imagen.setBackgroundResource(item.getImagen());
            txtCasa.setText(item.getNombre());
            txtHabitaciones.setText(String.valueOf(item.getTotalHabitaciones()));
            txtArea.setText(String.valueOf(item.getTotalArea()));

            btn_proforma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProformaActivity.class);
                    intent.putExtra("casa", item);
                    context.startActivity(intent);
                }
            });
        }
    }
}
