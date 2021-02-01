package com.example.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.sqlitedemo.model.*;

public class  adapter extends RecyclerView.Adapter<adapter.myviewHolder> {

    ArrayList<model>l;
      ImageView img2;
     Context context;
     DbHelper db;

    public adapter(ArrayList<model> l, ImageView img2, Context context) {
        this.l = l;
        this.img2 = img2;
        this.context = context;
        db= new DbHelper(context);
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new   myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewHolder holder, final
    int position) {




        final model temp=l.get(position);
        holder.dnote.setText(l.get(position).getNote());


        holder.dnote.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                holder.dnote.setBackgroundColor(Color.RED);

                img2.setVisibility(View.VISIBLE);

                img2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        db.deletedata((String) holder.dnote.getText());
                        l.remove(holder.getAdapterPosition());

                        notifyItemRemoved(holder.getAdapterPosition());
                    }
                });

                return false;
            }
        });






    }

    @Override
    public int getItemCount() {
        return l.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder
    {
        TextView dnote;


        public myviewHolder(@NonNull final View itemView) {
            super(itemView);


            dnote=itemView.findViewById(R.id.text1);






        }
    }


  }
