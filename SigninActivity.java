package com.example.sign_inlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edituser,editpass;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edituser=findViewById(R.id.newUserName);
        editpass=findViewById(R.id.newPassWord);
        bt=findViewById(R.id.signInBtn);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edituser.getText().toString();
                String password=editpass.getText().toString();
                if(isValidPassword(password)){
                    Intent intent = new Intent(MainActivity.this, loginActivity.class);
                    intent.putExtra("Email",email);
                    intent.putExtra("Password",password);
                    startActivity(intent);
                } else if (email.length()==0) {
                    Toast.makeText(MainActivity.this, "Enter some name", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter valid Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
    Pattern lc = Pattern.compile("^.*[a-z].*$");
    Pattern uc = Pattern.compile("^.*[A-Z].*$");
    Pattern num = Pattern.compile("^.*[0-9].*$");
    private boolean isValidPassword(String password){
        if(password.length()<8)
            return false;
        if(!lc.matcher(password).matches())
            return false;
        if(!uc.matcher(password).matches())
            return false;
        if(!num.matcher(password).matches())
            return false;
        return true;
    }
}