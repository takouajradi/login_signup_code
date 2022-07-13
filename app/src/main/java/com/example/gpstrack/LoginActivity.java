package com.example.gpstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText TTNumber,password;
    Button signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TTNumber=findViewById(R.id.TTNumber1);
        password=findViewById(R.id.password1);
        signin=findViewById(R.id.signin1);
        DB= new DBHelper(this);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String TTN=TTNumber.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(TTN) || TextUtils.isEmpty(pass))
                    Toast.makeText(LoginActivity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkTTNpass=DB.InsertData(TTN,pass);
                    if(checkTTNpass==true){
                        Toast.makeText(LoginActivity.this, "Login Successful ", Toast.LENGTH_SHORT).show();
                        Intent intent=  new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });




    }
}