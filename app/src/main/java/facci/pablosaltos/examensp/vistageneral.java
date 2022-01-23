package facci.pablosaltos.examensp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import facci.pablosaltos.examensp.adaptadores.adaptador_transportista;
import facci.pablosaltos.examensp.modelos.modelo_trasnportista;

public class vistageneral extends AppCompatActivity {
    Button Registrarboton;
    RecyclerView recyclerTransportistas;
    adaptador_transportista adaptador_transportistas;
    List<modelo_trasnportista> trasnportistas;
    private FirebaseFirestore basedatos;
    String id, cedula, nombres, apellidos, direccion, tipovehiculo, cooperativa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistageneral);
        basedatos = FirebaseFirestore.getInstance();

        recyclerTransportistas = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerTransportistas.setLayoutManager(new LinearLayoutManager(this));
        trasnportistas = new ArrayList<>();
        adaptador_transportistas = new adaptador_transportista(trasnportistas);
        recyclerTransportistas.setAdapter(adaptador_transportistas);

        basedatos.collection("transportista").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException e) {
                trasnportistas.removeAll(trasnportistas);
                for(DocumentSnapshot docsna:value.getDocuments()){
                    id = docsna.getId();
                    cedula = docsna.getString("cedula");
                    nombres = docsna.getString("nombres");
                    apellidos = docsna.getString("apellidos");
                    direccion = docsna.getString("direccion");
                    tipovehiculo = docsna.getString("tipovehiculo");
                    cooperativa = docsna.getString("cooperativa");
                    trasnportistas.add(new modelo_trasnportista(id, cedula, nombres, apellidos, direccion, tipovehiculo, cooperativa));
                }
                adaptador_transportistas.notifyDataSetChanged();
            }
        });
        Registrarboton = findViewById(R.id.registrar);
        Registrarboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), registro.class));
            }
        });
    }
}