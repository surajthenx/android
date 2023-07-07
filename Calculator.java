package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2,operation;
    TextView result;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.eText1);
        editText2=findViewById(R.id.eText2);
        operation=findViewById(R.id.opEr);
        result=findViewById(R.id.res);

        editText1.setShowSoftInputOnFocus(false);
        editText2.setShowSoftInputOnFocus(false);
        operation.setShowSoftInputOnFocus(false);
    }
    public void add(View view){
        op='+';
        operation.setText("+");
    }
    public void sub(View view){
        op='-';
        operation.setText("-");
    }
    public void mul(View view){
        op='*';
        operation.setText("x");
    }
    public void div(View view){
        op='/';
        operation.setText("/");
    }
    public void equals(View view){
        double n1,n2,ans;
        switch (op){
            case '+':n1=Double.parseDouble(editText1.getText().toString());
                    n2=Double.parseDouble(editText2.getText().toString());
                    ans=n1+n2;
                    result.setText(" "+ans);
                    break;

            case '-':n1=Double.parseDouble(editText1.getText().toString());
                    n2=Double.parseDouble(editText2.getText().toString());
                    ans=n1-n2;
                    result.setText(" "+ans);
                    break;

            case '*':n1=Double.parseDouble(editText1.getText().toString());
                    n2=Double.parseDouble(editText2.getText().toString());
                    ans=n1*n2;
                    result.setText(" "+ans);
                    break;

            case '/':n1=Double.parseDouble(editText1.getText().toString());
                    n2=Double.parseDouble(editText2.getText().toString());
                    ans=n1/n2;
                    result.setText(" "+ans);
                    break;
        }
    }
    public void one(View view){
        if(editText1.hasFocus()){
            editText1.append("1");
        }
        if(editText2.hasFocus()){
            editText2.append("1");
        }
    }

    public void two(View view){
        if(editText1.hasFocus()){
            editText1.append("2");
        }
        if(editText2.hasFocus()){
            editText2.append("2");
        }
    }

    public void three(View view){
        if(editText1.hasFocus()){
            editText1.append("3");
        }
        if(editText2.hasFocus()){
            editText2.append("3");
        }
    }

    public void four(View view){
        if(editText1.hasFocus()){
            editText1.append("4");
        }
        if(editText2.hasFocus()){
            editText2.append("4");
        }
    }

    public void five(View view){
        if(editText1.hasFocus()){
            editText1.append("5");
        }
        if(editText2.hasFocus()){
            editText2.append("5");
        }
    }

    public void six(View view){
        if(editText1.hasFocus()){
            editText1.append("6");
        }
        if(editText2.hasFocus()){
            editText2.append("6");
        }
    }

    public void seven(View view){
        if(editText1.hasFocus()){
            editText1.append("7");
        }
        if(editText2.hasFocus()){
            editText2.append("7");
        }
    }

    public void eight(View view){
        if(editText1.hasFocus()){
            editText1.append("8");
        }
        if(editText2.hasFocus()){
            editText2.append("8");
        }
    }

    public void nine(View view){
        if(editText1.hasFocus()){
            editText1.append("9");
        }
        if(editText2.hasFocus()){
            editText2.append("9");
        }
    }

    public void zero(View view){
        if(editText1.hasFocus()){
            editText1.append("0");
        }
        if(editText2.hasFocus()){
            editText2.append("0");
        }
    }

    public void dot(View view){
        if(editText1.hasFocus()){
            editText1.append(".");
        }
        if(editText2.hasFocus()){
            editText2.append(".");
        }
    }

    public void clear(View view){
        if(editText1.hasFocus()){
            editText1.setText(" ");
        }
        if(editText2.hasFocus()){
            editText2.setText(" ");
        }
        if(operation.hasFocus()){
            operation.setText(" ");
        }
    }
}