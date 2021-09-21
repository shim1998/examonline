package com.example.examonline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity2 extends AppCompatActivity {
    EditText name,email,pass,passnew;
    Button register;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name= (EditText)findViewById(R.id.entry1name);
        email= (EditText) findViewById(R.id.entry1mail);
        pass= (EditText) findViewById(R.id.entry1pass);
        passnew =(EditText) findViewById(R.id.entry1pass1);
        register= (Button) findViewById(R.id.signup);
        fauth = FirebaseAuth.getInstance();

        TextView login =(TextView) findViewById(R.id.jumptologin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(MainActivity2.this, login.class);
                startActivity(log);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}