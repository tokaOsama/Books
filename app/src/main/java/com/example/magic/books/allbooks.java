package com.example.magic.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import database.SQLite;

public class allbooks extends AppCompatActivity {

    ListView listView ;
    SQLite sqLite ;
    Custom custom ;
    ArrayList<ModelList> arrayList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allbooks);

        listView = (ListView) findViewById(R.id.listview);
        arrayList = new ArrayList<>();

        sqLite = new SQLite(allbooks.this);
        arrayList =sqLite.allBooks();

        custom = new Custom(allbooks.this, arrayList);
        listView.setAdapter(custom);


    }
}
