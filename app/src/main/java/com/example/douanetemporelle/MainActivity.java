
package com.example.douanetemporelle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nom, anneeNaissance, anneeVoyage, motif;
    Button btnVerifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.woNom);
        anneeNaissance = findViewById(R.id.woAnneeNaissance);
        anneeVoyage = findViewById(R.id.woAnneeVoyage);
        motif = findViewById(R.id.woMotif);
        btnVerifier = findViewById(R.id.woBtnVerifier);

        btnVerifier.setOnClickListener(v -> {

            String nomText = nom.getText().toString().trim();
            String naissanceText = anneeNaissance.getText().toString().trim();
            String voyageText = anneeVoyage.getText().toString().trim();
            String motifText = motif.getText().toString().trim();

            if (nomText.isEmpty() || naissanceText.isEmpty()
                    || voyageText.isEmpty() || motifText.isEmpty()) {

                Toast.makeText(this,
                        "Please fill in all fields",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            int naissance;
            int voyage;

            try {
                naissance = Integer.parseInt(naissanceText);
                voyage = Integer.parseInt(voyageText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid year",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (naissance < 1900 || naissance > 2026) {
                Toast.makeText(this, "Invalid birth year",
                        Toast.LENGTH_SHORT).show();

            } else if (voyage < 1900 || voyage > 3000) {
                Toast.makeText(this, "Invalid travel year",
                        Toast.LENGTH_SHORT).show();

            } else {
                Intent intent = new Intent(
                        MainActivity.this, ResultActivity.class);

                intent.putExtra("nom", nomText);
                intent.putExtra("motif", motifText);
                intent.putExtra("naissance", naissance);
                intent.putExtra("voyage", voyage);
                intent.putExtra("accepte", true);

                startActivity(intent);
            }
        });
    }
}
