package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class fetchdata extends AppCompatActivity{


    RecyclerView recyclerView;
      ImageView img2;
      int id=0;
    ArrayList<model>l=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);

        img2=findViewById(R.id.img2);
        recyclerView=findViewById(R.id.recyv);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new DbHelper(this).readalldata();



        while(cursor.moveToNext())
        {

             model obj=new model(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
             l.add(obj);
        }
        adapter adap=new adapter(l,img2,getApplicationContext());
        recyclerView.setAdapter(adap);


    }




}