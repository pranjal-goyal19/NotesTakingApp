package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add;
    EditText t1;
    ImageView img1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         add=findViewById(R.id.button);
          img1=findViewById(R.id.img1);


   t1 =findViewById(R.id.t1);

        new DbHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });


    }
    public void insert()
    {
        DbHelper db=new DbHelper(this);
        String res=db.addRecord(t1.getText().toString());
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();
        t1.setText("");

    }

}