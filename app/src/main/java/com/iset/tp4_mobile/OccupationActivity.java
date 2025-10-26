package com.iset.tp4_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class OccupationActivity extends AppCompatActivity {

    private TextView txtNom, txtCategorie, txtDesc;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation);

        // Lier les vues
        txtNom = findViewById(R.id.txtNomOccupation);
        txtCategorie = findViewById(R.id.txtCategorieOccupation);
        txtDesc = findViewById(R.id.txtDescOccupation);
        btnRetour = findViewById(R.id.btnRetour);

        // Récupérer l'occupation passée via Intent
        int occupationId = getIntent().getIntExtra("occupationId", -1);
        Occupation occupation = OccupationsSingleton.getInstance().getOccupation(occupationId);

        if (occupation != null) {
            txtNom.setText(occupation.getNom());
            txtCategorie.setText(occupation.getCategorie());
            txtDesc.setText(occupation.getDescription());
        } else {
            txtNom.setText("Occupation inconnue");
            txtCategorie.setText("");
            txtDesc.setText("");
        }

        // Bouton Retour pour fermer l'activité
        btnRetour.setOnClickListener(v -> finish());
    }

    @Override
    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        // Mettre à jour les infos si singleTop
        int occupationId = intent.getIntExtra("occupationId", -1);
        Occupation occupation = OccupationsSingleton.getInstance().getOccupation(occupationId);

        if (occupation != null) {
            txtNom.setText(occupation.getNom());
            txtCategorie.setText(occupation.getCategorie());
            txtDesc.setText(occupation.getDescription());
        } else {
            txtNom.setText("Occupation inconnue");
            txtCategorie.setText("");
            txtDesc.setText("");
        }
    }
}
