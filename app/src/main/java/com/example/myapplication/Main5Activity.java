package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
    ArrayList<Model> list = new ArrayList<>();
    Adapterlist adapterlist ;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recyclerView = findViewById(R.id.zz55z);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ref.child("bbbb").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    list.add(dataSnapshot1.getValue(Model.class));

                }

                Toast.makeText(Main5Activity.this, list.get(0).getName()+"", Toast.LENGTH_SHORT).show();
                adapterlist = new Adapterlist() ;
                adapterlist.setList(list);
                recyclerView.setAdapter(adapterlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
