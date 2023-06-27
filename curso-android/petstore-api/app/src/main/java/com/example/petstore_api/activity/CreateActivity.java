package com.example.petstore_api.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petstore_api.R;
import com.example.petstore_api.model.Item;
import com.example.petstore_api.response.ItemService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateActivity extends AppCompatActivity {

    private EditText etNome;
    private EditText etDescricao;
    private EditText etPreco;
    private EditText etImageUrl;
    private Button btnEnviar;

    private ItemService itemService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etNome = findViewById(R.id.etName);
        etDescricao = findViewById(R.id.etDescription);
        etPreco = findViewById(R.id.etPrice);
        etImageUrl = findViewById(R.id.etImageUrl);
        btnEnviar = findViewById(R.id.btnEnviar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://48d1-190-111-131-171.ngrok-free.app/") // Insira a URL base da sua API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        itemService = retrofit.create(ItemService.class);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = etNome.getText().toString();
                String descricao = etDescricao.getText().toString();
                double preco = Double.parseDouble(etPreco.getText().toString());
                String imageUrl = etImageUrl.getText().toString();

                Item item = new Item(nome, descricao, preco, imageUrl);

                createItem(item);
            }
        });

    }

    private void createItem(Item itemData) {
        Call<Item> call = itemService.createItem(itemData);
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if (response.isSuccessful()) {
                    // Requisição bem-sucedida
                    Toast.makeText(CreateActivity.this, "Dados enviados com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    // Requisição falhou
                    Toast.makeText(CreateActivity.this, "Falha ao enviar dados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(CreateActivity.this, "Falha ao enviar dados", Toast.LENGTH_SHORT).show();

            }
        });
    }

}