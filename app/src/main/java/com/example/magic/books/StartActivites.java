package com.example.magic.books;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class StartActivites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activites);
        Toast.makeText(this, " Welcome Dod !", Toast.LENGTH_SHORT).show();
    }
}
