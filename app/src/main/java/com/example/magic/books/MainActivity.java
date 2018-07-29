package com.example.magic.books;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.SQLite;

public class MainActivity extends AppCompatActivity  {

    EditText nameBook ;
    EditText author ;
    Button addButton ;
  //  ArrayList<ModelList> arrayList ;
//    Custom custom ;
    SharedPreferences sharedPreferences ;
    SharedPreferences.Editor editor ;
    SQLite sqLite ;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("pref_file", MODE_PRIVATE);

        addButton = (Button) findViewById(R.id.button);
        nameBook  = (EditText) findViewById(R.id.text1);
        author    = (EditText) findViewById(R.id.text2);

        sqLite = new SQLite(MainActivity.this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLite.addBook(nameBook.getText().toString(), author.getText().toString());
                Intent intent = new Intent(MainActivity.this,allbooks.class);
                startActivity(intent);
                nameBook.setText("");
                author.setText("");
            }
        });

        editor = sharedPreferences.edit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(MainActivity.this);
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.logout:
                Intent intent = new Intent(MainActivity.this , Login.class) ;
                startActivity(intent);
                editor.clear();
                editor.commit();
                editor.clear();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
