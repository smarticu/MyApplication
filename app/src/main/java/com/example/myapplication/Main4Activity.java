package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main4Activity extends AppCompatActivity {
   DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void request(View view) {
        reference.child("user").setValue(new Modelrequest("belal",9990));
        Toast.makeText(Main4Activity.this,"تم تنفيذ الطلب",Toast.LENGTH_SHORT).show();
    }

    public void book(View view) {
        startActivity(new Intent(Main4Activity.this,Main5Activity.class));

    }
}
