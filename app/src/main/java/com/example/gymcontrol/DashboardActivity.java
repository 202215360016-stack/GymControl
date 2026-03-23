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
        final MaterialCardView cardTreinos = findViewById(R.id.cardTreinos);
        final MaterialCardView cardPagamentos = findViewById(R.id.cardPagamentos);
        final MaterialCardView cardExercicios = findViewById(R.id.cardExercicios);
        final MaterialCardView cardEvolucao = findViewById(R.id.cardEvolucao);
        final MaterialCardView cardConfiguracoes = findViewById(R.id.cardConfiguracoes);
        final Button btnLogout = findViewById(R.id.btnLogout);

        cardAlunos.setOnClickListener(v -> startActivity(new Intent(this, AlunosActivity.class)));
        cardTreinos.setOnClickListener(v -> startActivity(new Intent(this, TreinosActivity.class)));
        cardPagamentos.setOnClickListener(v -> startActivity(new Intent(this, PagamentosActivity.class)));
        cardExercicios.setOnClickListener(v -> startActivity(new Intent(this, ExerciciosActivity.class)));
        cardEvolucao.setOnClickListener(v -> startActivity(new Intent(this, EvolucaoActivity.class)));
        cardConfiguracoes.setOnClickListener(v -> startActivity(new Intent(this, ConfiguracoesActivity.class)));

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
