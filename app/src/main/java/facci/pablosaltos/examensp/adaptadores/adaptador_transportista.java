package facci.pablosaltos.examensp.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import facci.pablosaltos.examensp.R;
import facci.pablosaltos.examensp.modelos.modelo_trasnportista;
import facci.pablosaltos.examensp.vistaindividual;

public class adaptador_transportista extends RecyclerView.Adapter<adaptador_transportista.ViewHolder>{

    public List<modelo_trasnportista> trasnportistaLista;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        private TextView cardnombres,cardapellidos, cardcooperativa;
        private String id;
        CardView cardtransportista;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            context=itemView.getContext();
            cardnombres= itemView.findViewById(R.id.cardnombres);
            cardapellidos = itemView.findViewById(R.id.cardapellidos);
            cardcooperativa = itemView.findViewById(R.id.cardcooperativa);
            cardtransportista = itemView.findViewById(R.id.cardtransportista);
        }
        void setOnClickListeners(){
            cardtransportista.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.cardtransportista:
                    context.startActivity(new Intent(context, vistaindividual.class).putExtra("id",id));
                    break;
            }
        }
    }

    public adaptador_transportista(List<modelo_trasnportista> trasnportistaLista) {
        this.trasnportistaLista = trasnportistaLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_transportista,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modelo_trasnportista transportista =trasnportistaLista.get(position);
        holder.cardnombres.setText(transportista.getNombres());
        holder.cardapellidos.setText(transportista.getApellidos());
        holder.cardcooperativa.setText(transportista.getCooperativa());
        holder.id = transportista.getId();
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return trasnportistaLista.size();
    }
}
