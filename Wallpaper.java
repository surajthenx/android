package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    Drawable drawable;
    WallpaperManager wpm;
    Timer myTimer;
    int preview=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTimer=new Timer();
        wpm=WallpaperManager.getInstance(this);
        changewallpaper=findViewById(R.id.button);
        changewallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setwallpaper();
            }
        });
    }
    public void setwallpaper(){
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(preview==1){
                    drawable=getResources().getDrawable(R.drawable.one);
                    preview=2;
                } else if (preview==2) {
                    drawable=getResources().getDrawable(R.drawable.two);
                    preview=3;
                } else if (preview==3) {
                    drawable=getResources().getDrawable(R.drawable.three);
                    preview=4;
                } else if (preview==4) {
                    drawable=getResources().getDrawable(R.drawable.four);
                    preview=5;
                } else {
                    drawable=getResources().getDrawable(R.drawable.five);
                    preview=1;
                }
                Bitmap wallpaper=((BitmapDrawable)drawable).getBitmap();
                try{
                    wpm.setBitmap(wallpaper);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        },0,10000);
    }
}