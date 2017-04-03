package com.example.silvan.finalapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Silvan on 09/02/2017.
 */

public class Settings extends PreferenceActivity  implements SharedPreferences.OnSharedPreferenceChangeListener {
    private SharedPreferences SP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SP = PreferenceManager.getDefaultSharedPreferences(this);
        SP.registerOnSharedPreferenceChangeListener(this);
        ponTema(SP);
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

    }
    private void ponTema(SharedPreferences SP){
        boolean appTheme = SP.getBoolean("temaAplicacion", true);
        if (appTheme){
            this.setTheme(R.style.LightTheme);
        }
        else {
            this.setTheme(R.style.BlackTheme);
        }
    }


    public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        finish();
        startActivity(getIntent());
    }

    //@Override
    //public void onBackPressed() {
        /*
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);*/
    //}

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, Settings.class);
        startActivity(refresh);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        ponTema(SP);
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        ponTema(SP);
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        ponTema(SP);
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

}
