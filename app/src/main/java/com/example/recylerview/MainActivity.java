package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //refactrinh here
    ArrayList<Exampleitem>exampleList;
    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;
// out recylerview cannot talk with data so we use arrayadapter so we can talk
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateFakeData();
        //config for recyler view
      recyclerViewConfig();
      buttonAdd=findViewById(R.id.buttonadd);
        buttonDelete=findViewById(R.id.buttondelete);
        editTextAdd=findViewById(R.id.edittextadd);
        editTextDelete=findViewById(R.id.edittextdelete);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=editTextAdd.getText().toString();
                if(TextUtils.isEmpty(s))
                {
                    Toast.makeText(MainActivity.this, "plz enter", Toast.LENGTH_SHORT).show();
                }

                else {
                    int position = Integer.parseInt(editTextAdd.getText().toString());

                    addCard(position);
                }
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s=editTextDelete.getText().toString();
                if(TextUtils.isEmpty(s))
                {
                    Toast.makeText(MainActivity.this, "plz enter", Toast.LENGTH_SHORT).show();
                }
                else {
                    int position = Integer.parseInt(editTextDelete.getText().toString());
                    deleteCard(position);
                }
            }
        });

    }


    public  void recyclerViewConfig(){


        recyclerView=findViewById(R.id.recylerview);
        //performances make fast
        recyclerView.setHasFixedSize(true);  //more than 1000 ya 2000 student in your profile this oneline make a differnce work fast
        layoutManager=new LinearLayoutManager(this);

        adapter=new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
    public void  addCard(int postion){
        exampleList.add(postion,new Exampleitem(R.drawable.node,"new card added"));
       //adapter.notifyDataSetChanged(); this is also work
        adapter.notifyItemInserted(postion);//thss is better solution
    }

    public void  deleteCard(int postion){
        exampleList.remove(postion);
        adapter.notifyItemRemoved(postion);

    }





    public void  generateFakeData(){

        exampleList=new ArrayList<>();
        exampleList.add(new Exampleitem(R.drawable.node,"CLicked at studio"));
        exampleList.add(new Exampleitem(R.drawable.oner,"CLicked at Itlay"));
        exampleList.add(new Exampleitem(R.drawable.twor,"CLicked at Rome"));
        exampleList.add(new Exampleitem(R.drawable.threer,"CLicked at Greece"));
        exampleList.add(new Exampleitem(R.drawable.fourr,"CLicked at Rome"));
        exampleList.add(new Exampleitem(R.drawable.fiver,"CLicked at  Paris"));
        exampleList.add(new Exampleitem(R.drawable.sixr,"CLicked at India"));



    }

}