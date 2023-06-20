package com.example.retrofit.ui.detalhesFilme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.R;
import com.example.retrofit.data.model.Filme;

import java.io.Serializable;

public class DetalhesFilmeActivity extends AppCompatActivity {

    public static final String EXTRA_FILME = "EXTRA_FILME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);

        TextView txtTituloFilme = findViewById(R.id.txt_Titulo_Filme);

        final Filme filme = (Filme) getIntent().getSerializableExtra(EXTRA_FILME);

        txtTituloFilme.setText(filme.getTitulo());
    }
}