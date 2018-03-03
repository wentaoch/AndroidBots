package com.example.fatin.foodbasket;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{
    private Button register_btn;
    private EditText user_name;
    private EditText user_password;
    private EditText user_email;

    FirebaseAuth firebaseAuth =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        register_btn =(Button) findViewById(R.id.registerBtn);
        user_email =(EditText)findViewById(R.id.email);
        user_password=(EditText)findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        register_btn.setOnClickListener(this);
        user_name =(EditText)findViewById(R.id.username);
    }

    @Override
    public void onClick(View view) {
        String _user_email = user_email.getText().toString();
        String _password = user_password.getText().toString();
        String _username = user_name.getText().toString();

        registerUser(_user_email,_password,_username);
    }

    private void registerUser(final String userEmail,final String userPassword, final String userName) {
       firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
           @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Main5Activity.this,userName +" Account Created Sucessfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main5Activity.this, Main3Activity.class);
                    startActivity(intent);
                }else {

                    Toast.makeText(Main5Activity.this,user_name+" Account Created Unsucessfully", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
