package com.example.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    public ArrayList<Exampleitem> mExampleList;


  //create class 1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        //4
         public ImageView imageView;
         public TextView textView;

        //cgenerate this 2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            //4 carry one
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
//6.1  //we are creating it doesnt know why we are creating this ,reson
    //it doesn't know how many item should generate
    public ExampleAdapter(ArrayList<Exampleitem> exampleList){
        mExampleList=exampleList;

    }


//genear
// ate three method 3

    @Override
    public ExampleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        //5 here we are inflate out layout
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);

        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return  exampleViewHolder;
    }
//7 //these are the call as soon as we scroll them
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Exampleitem currentItem=mExampleList.get(position);
        holder.imageView.setImageResource(currentItem.getmImageResource());
        holder.textView.setText(currentItem.getmText());
    }

    @Override
    public int getItemCount() {
        return  mExampleList.size();
    }



}
