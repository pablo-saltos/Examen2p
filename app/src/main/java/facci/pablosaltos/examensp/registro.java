package facci.pablosaltos.examensp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registro extends AppCompatActivity {
    public FirebaseFirestore database;
    public TextInputEditText cedula, nombres, apellidos, direccion, tipovehiculo, cooperativa;
    public Button b_guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        database = FirebaseFirestore.getInstance();

        cedula = findViewById(R.id.cedula);
        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        direccion = findViewById(R.id.direccion);
        tipovehiculo = findViewById(R.id.tipovehiculo);
        cooperativa = findViewById(R.id.cooperativa);
        b_guardar = findViewById(R.id.b_guardar);

        b_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Map<String, Object> transportista = new HashMap<>();
                transportista.put("cedula",cedula.getText().toString());
                transportista.put("nombres",nombres.getText().toString());
                transportista.put("apellidos",apellidos.getText().toString());
                transportista.put("direccion",direccion.getText().toString());
                transportista.put("tipovehiculo",tipovehiculo.getText().toString());
                transportista.put("cooperativa",cooperativa.getText().toString());

                database.collection("transportista").document().set(transportista).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("transportista",  "Añádido");
                        finish();
                    }
                });
            }
        });
    }
}