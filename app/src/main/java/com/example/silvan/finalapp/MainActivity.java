package com.example.silvan.finalapp;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends PersonalActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(MainActivity.this, EscogeCentro.class);
                startActivity(i);
            }//run
        }//runnable
        );
        th.start();
    }
}
