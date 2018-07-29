package com.example.magic.books;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class detailesofbook extends AppCompatActivity {

    TextView text1 ;
    TextView text2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailesofbook);

        text1 = (TextView) findViewById(R.id.text2);
        text2 = (TextView) findViewById(R.id.text3);

        text1.setText(getIntent().getStringExtra("item1"));
        text2.setText(getIntent().getStringExtra("item2"));
    }
}
