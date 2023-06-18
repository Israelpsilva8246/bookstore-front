package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.model.Emails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmailAdapter emailAdapter = new EmailAdapter(new ArrayList<>(Emails.fakeEmails()));

        RecyclerView rv = findViewById(R.id.recycler_view_main);
        rv.setAdapter(emailAdapter);
    }
}