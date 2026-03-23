package com.example.gymcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final MaterialCardView cardAlunos = findViewById(R.id.cardAlunos);
        final MaterialCardView cardPagamentos = findViewById(R.id.cardPagamentos);
        final Button btnLogout = findViewById(R.id.btnLogout);

        cardAlunos.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, AlunosActivity.class));
        });

        cardPagamentos.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, PagamentosActivity.class));
        });

        btnLogout.setOnClickListener(v -> {
            finish();
        });
    }
}
