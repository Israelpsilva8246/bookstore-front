package com.example.petstore_api;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petstore_api.model.Item;
import com.example.petstore_api.model.Post;
import com.example.petstore_api.response.ItemService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    private ItemService itemService;
    private RecyclerView recyclerView;
    private List<Item> items;
    private String baseUrl = "https://3a6e-190-111-131-66.ngrok-free.app/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.rv);

        items = new ArrayList<>();

        viewJsonData();
    }

    private void viewJsonData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        itemService = retrofit.create(ItemService.class);

        Call<List<Item>> itemsCall = itemService.getItem();

        itemsCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                items = response.body();
                int i = 0;
                for (i = 0; i < items.size(); i++) {

                    ItemAdapter itemAdapter = new ItemAdapter(items, ListActivity.this);

                    LinearLayoutManager manager = new LinearLayoutManager(ListActivity.this,
                            RecyclerView.VERTICAL, false);

                    recyclerView.setLayoutManager(manager);

                    recyclerView.setAdapter(itemAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }
}