package com.example.gymcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        LinearLayout layout = findViewById(R.id.main_layout);
        
        Class<?>[] activities = {
            LoginActivity.class, RegisterActivity.class, DashboardActivity.class,
            AlunosActivity.class, CadastroAlunoActivity.class, ConfiguracoesActivity.class,
            EvolucaoActivity.class, ExerciciosActivity.class, HistoricoTreinoActivity.class,
            InstrutorActivity.class, MensalidadeActivity.class, MontarTreinoActivity.class,
            PagamentosActivity.class, TreinosActivity.class
        };
        
        for (Class<?> activityClass : activities) {
            Button btn = new Button(this);
            btn.setText("Abrir " + activityClass.getSimpleName().replace("Activity", ""));
            
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 16);
            btn.setLayoutParams(params);
            
            btn.setOnClickListener(v -> {
                startActivity(new Intent(MainActivity.this, activityClass));
            });
            
            layout.addView(btn);
        }
    }
}