package com.example.petshop.ui.listaitems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.petshop.R;
import com.example.petshop.data.model.Item;
import com.example.petshop.data.network.ApiService;
import com.example.petshop.data.network.ItemsService;
import com.example.petshop.data.network.response.ItemsResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListaItemAdapter itemAdapter;

    private Lis.ListaFilmesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_main);

        txtView = findViewById(R.id.txt_name_item);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://a22b-190-111-131-90.ngrok-free.app/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        ItemsService itemsService = retrofit.create(ItemsService.class);

        Call<List<Item>> call = itemsService.getItems();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText()
            }
        });

    }
}