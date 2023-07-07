package com.example.call;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phonenumberEditText;

    Button btndelete,btncall,btnsave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenumberEditText=findViewById(R.id.phoneNumber);
        btndelete=findViewById(R.id.btnDelete);
        btncall=findViewById(R.id.btnCall);
        btnsave=findViewById(R.id.btnSave);

        phonenumberEditText.setShowSoftInputOnFocus(false);

        //function for delete
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph=phonenumberEditText.getText().toString();
                if(ph.length()>0){
                    ph=ph.substring(0,ph.length()-1);
                }
                phonenumberEditText.setText(ph);
            }
        });

        //function for calling
        btncall.setOnClickListener(view -> {
            String phonenumber=phonenumberEditText.getText().toString();
            Intent intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phonenumber));
            startActivity(intent);
        });

        //function for saving
        btnsave.setOnClickListener(view -> {
            String phonenumber=phonenumberEditText.getText().toString();
            Intent intent=new Intent(Intent.ACTION_INSERT);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.PHONE,phonenumber);
            startActivity(intent);
        });
    }

    @SuppressLint("SetTextI18n")
    public void inputNumber(View view){
        Button btn=(Button)view;
        String digit=btn.getText().toString();
        String phonenumber=phonenumberEditText.getText().toString();
        phonenumberEditText.setText(phonenumber+digit);
    }
}