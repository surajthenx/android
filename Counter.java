package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnpause,btnstart,btnstop;
    Button btnreset;
    TextView counter;
    int i=1;
    Handler customhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnpause=findViewById(R.id.buttonPause);
        btnreset=findViewById(R.id.buttonReset);
        btnstart=findViewById(R.id.buttonStart);
        btnstop=findViewById(R.id.buttonStop);
        counter=findViewById(R.id.textView);
        customhandler=new Handler();

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.postDelayed(UpadateTimerThread,0);
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.removeCallbacks(UpadateTimerThread);
                i=1;
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.removeCallbacks(UpadateTimerThread);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customhandler.equals(i=1);
                customhandler.postDelayed(UpadateTimerThread,0);
            }
        });
    }
    private final Runnable UpadateTimerThread=new Runnable() {
        @Override
        public void run() {
            counter.setText(""+i);
            customhandler.postDelayed(this,1000);
            customhandler.getLooper();
            i=i+1;
        }
    };
}