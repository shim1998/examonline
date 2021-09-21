package com.example.examonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity2 extends AppCompatActivity {
    EditText name,email,pass;
    Button register;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name= (EditText)findViewById(R.id.entry1name);
        email= (EditText) findViewById(R.id.entry1maillog);
        pass= (EditText) findViewById(R.id.entry1passlog);
        register= (Button) findViewById(R.id.login);
        fauth = FirebaseAuth.getInstance();

        TextView login =(TextView) findViewById(R.id.jumptologin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(MainActivity2.this, login.class);
                startActivity(log);
            }
        });

        if(fauth.getCurrentUser() !=null)
        {
            startActivity(new Intent(getApplicationContext(),dashboard.class));
            finish();
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1= email.getText().toString().trim();
                String pass1= pass.getText().toString().trim();
                String name1= name.getText().toString().trim();

                if(pass1.length()<7)
                {
                    pass.setError("The password should at least contain 7 elements");
                    return;
                }
                if(TextUtils.isEmpty(email1) && TextUtils.isEmpty(name1))
                {
                    email.setError("This field cannot be empty");
                    name.setError("This field cannot be empty");
                }

                // register the user
                fauth.createUserWithEmailAndPassword(email1,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity2.this, "Account created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),dashboard.class));

                        }
                        else
                        {
                            Toast.makeText(MainActivity2.this, "Account not created", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}