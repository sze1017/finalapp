package com.example.silvan.finalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Silvan on 09/02/2017.
 */

public class EscogeCentro extends PersonalActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escoge_escuela);

        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lanzarSettings();
            }
        });

        Button b2 = (Button) findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                lanzarSettings();
            }
        });
    }

    private void lanzarSettings(){
        String nombre = this.getClass().getCanonicalName();
        Intent intent = new Intent(EscogeCentro.this, Settings.class);
        intent.putExtra("callingActivity", nombre );
        startActivity(intent);
    }
}
