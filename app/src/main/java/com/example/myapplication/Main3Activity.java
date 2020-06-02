package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
  EditText email,password;
  FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        email=findViewById(R.id.in_email);
        password=findViewById(R.id.in_password);
    }

    public void login(View view) {
        resteration();
    }
       protected void resteration(){
        String mail=email.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(mail.equals("")||pass.equals(""))
            Toast.makeText(Main3Activity.this, "please check data", Toast.LENGTH_SHORT).show();
        auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Main3Activity.this,"successful",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main3Activity.this,Main4Activity.class));
                }else {
                    Toast.makeText(Main3Activity.this,task.getException().getMessage()+"",Toast.LENGTH_SHORT).show();
                }

            }
        });


       }
       }

