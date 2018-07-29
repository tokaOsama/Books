package com.example.magic.books;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class Custom extends ArrayAdapter<ModelList> {
    Context context;
    public Custom(Context context, ArrayList<ModelList> objects) {
        super(context, 0 , objects);
        this.context = context ;
    }

    @NonNull
    @Override
        public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.activity_books,parent,false);
        ModelList modelList  =  getItem(position);
        TextView  editText1  = (TextView)  convertView.findViewById(R.id.text1);
        TextView  editText2  = (TextView)  convertView.findViewById(R.id.text2);
        TextView  textView   = (TextView)  convertView.findViewById(R.id.circle);

        editText1.setText(modelList.getEdittext1());
        editText2.setText(modelList.getEdittext2());
        textView.setText(modelList.getImageCircle()+"");

        return convertView  ;
    }
}
