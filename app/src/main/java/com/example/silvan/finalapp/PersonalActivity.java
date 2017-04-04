package com.example.silvan.finalapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Silvan on 15/02/2017.
 */

public class PersonalActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        this.setTheme();
        super.onCreate(savedInstanceState);
    }

    private void setTheme(){
        int version = android.os.Build.VERSION.SDK_INT;
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean appTheme = SP.getBoolean("temaAplicacion", true);
        if (appTheme){
            this.setTheme(R.style.AppTheme);
        }
        else {
            this.setTheme(R.style.AppThemeDark);
        }
    }

}
