package com.example.petshop.ui.listaitems;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.petshop.R;

public class MainActivity extends AppCompatActivity {

    private TextView txtItem;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtItem = findViewById(R.id.txt_item_content);
    }
}