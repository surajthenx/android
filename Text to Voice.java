package com.example.thevoice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextText);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
    }
    public void ConvertText(View view){
        String s1=e1.getText().toString();
        if(s1.isEmpty()!=true){
            Toast.makeText(this,"converting the text",Toast.LENGTH_SHORT).show();
            t1.speak(s1,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else{
            Toast.makeText(this,"enter some text",Toast.LENGTH_SHORT).show();
        }
    }
}