package com.example.sign_inlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText uname,pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname=findViewById(R.id.userName);
        pass=findViewById(R.id.passWord);
        btn=findViewById(R.id.loginBtn);

        String reguname=getIntent().getStringExtra("Email");
        String regpass=getIntent().getStringExtra("Password");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredEmail=uname.getText().toString();
                String enteredPass=pass.getText().toString();
                if(enteredEmail.equals(reguname) && enteredPass.equals(regpass)){
                    Toast.makeText(loginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(loginActivity.this, "LOGIN FAILED, Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}