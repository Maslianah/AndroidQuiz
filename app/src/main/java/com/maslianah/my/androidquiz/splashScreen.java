package com.maslianah.my.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().setTitle("XYZ COMPANY");
        Thread myThread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(5000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}