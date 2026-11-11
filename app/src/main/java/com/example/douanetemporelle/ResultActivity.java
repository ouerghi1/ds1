
package com.example.douanetemporelle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultTitle, resultDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTitle = findViewById(R.id.resultTitle);
        resultDetails = findViewById(R.id.resultDetails);

        String nom = getIntent().getStringExtra("nom");
        String motif = getIntent().getStringExtra("motif");
        int naissance = getIntent().getIntExtra("naissance", 0);
        int voyage = getIntent().getIntExtra("voyage", 0);
        boolean accepte = getIntent().getBooleanExtra("accepte", false);

        if (accepte) {
            resultTitle.setText("JOURNEY APPROVED!");

            resultDetails.setText(
                    "Welcome " + nom +
                            "\n\nBirth Year: " + naissance +
                            "\nTravel Year: " + voyage +
                            "\nReason: " + motif +
                            "\n\nYour journey is authorized!"
            );

        } else {
            resultTitle.setText("JOURNEY REJECTED!");

            resultDetails.setText(
                    "Sorry " + nom +
                            "\n\nYour journey is not authorized."
            );
        }
    }
}
