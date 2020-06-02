package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singup(View view) {
           startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }

    public void singin(View view) {
        startActivity(new Intent(MainActivity.this,Main3Activity.class));
    }
}
