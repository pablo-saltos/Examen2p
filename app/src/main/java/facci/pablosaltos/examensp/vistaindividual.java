package facci.pablosaltos.examensp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class vistaindividual extends AppCompatActivity {
    private String id;
    private FirebaseFirestore database;
    private TextView mostrarcedula, mostrarnombres, mostrarapellidos, mostrardireccion, mostrartipovehiculo, mostrarcooperativa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistaindividual);
        id = getIntent().getStringExtra("id");
        database = FirebaseFirestore.getInstance();
        mostrarcedula = findViewById(R.id.mostarcedula);
        mostrarnombres = findViewById(R.id.nombresmostrar);
        mostrarapellidos = findViewById(R.id.apellidosmostrar);
        mostrardireccion = findViewById(R.id.mostrardireccion);
        mostrartipovehiculo = findViewById(R.id.mostrartipoveiculo);
        mostrarcooperativa = findViewById(R.id.mostrarcooperatica);
        DocumentReference dr = database.collection("transportista").document(id);
        dr.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if (task.isSuccessful()){
                        DocumentSnapshot docsnap = task.getResult();
                        if (docsnap.exists()){
                            mostrarcedula.setText(docsnap.getString("cedula"));
                            mostrarnombres.setText(docsnap.getString("nombres"));
                            mostrarapellidos.setText(docsnap.getString("apellidos"));
                            mostrardireccion.setText(docsnap.getString("direccion"));
                            mostrartipovehiculo.setText(docsnap.getString("tipovehiculo"));
                            mostrarcooperativa.setText(docsnap.getString("cooperativa"));
                        }
                    }

            }
        });
    }

}