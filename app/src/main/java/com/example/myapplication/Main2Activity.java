package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    EditText username, email, password, address, phone;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    ArrayList<Model> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.up_username);
        email = findViewById(R.id.up_email);
        password = findViewById(R.id.up_password);
        address = findViewById(R.id.up_address);
        phone = findViewById(R.id.up_phone);


    }


    public void send(View view) {
    registeration();

    }
    protected void registeration() {

        String name = username.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String add = address.getText().toString().trim();
        String mob = phone.getText().toString().trim();
        if (name.equals("") || pass.equals("") || mail.equals("") || add.equals("") || mob.equals(""))



        Toast.makeText(Main2Activity.this, "please check data", Toast.LENGTH_SHORT).show();

        else{
            auth.createUserWithEmailAndPassword(mail, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                               @Override
                                               public void onComplete(@NonNull Task<AuthResult> task) {
                                                   if (task.isSuccessful()) {
                                                       Toast.makeText(Main2Activity.this, "successful registeration", Toast.LENGTH_SHORT).show();
                                                       startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                                                       finish();

                                                   } else {
                                                       Toast.makeText(Main2Activity.this, task.getException().getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                                                   }
                                               }

                                           }

                    );
        }
    }
}











