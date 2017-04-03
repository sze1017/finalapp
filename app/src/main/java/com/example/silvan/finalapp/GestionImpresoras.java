package com.example.silvan.finalapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Silvan on 20/02/2017.
 */

public class GestionImpresoras extends PersonalActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        setContentView(R.layout.gest_impresoras_sabadell);
    }
}

