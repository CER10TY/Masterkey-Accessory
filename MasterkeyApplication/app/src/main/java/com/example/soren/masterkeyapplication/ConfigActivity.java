package com.example.soren.masterkeyapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void save_settings(View view) {
        // Fetches PWs and makes them accessible to MainActivity.java
        EditText key_master = (EditText) findViewById(R.id.masterkey_pw_settings);
        EditText pw_security = (EditText) findViewById(R.id.conf_pw_settings);

        // Saves passwords to SharedPref file for future use
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("masterkey", key_master.getText().toString());
        editor.putString("pw", pw_security.getText().toString());
        editor.commit();

        // Distributes password.
        Intent resultIntent = new Intent();
        resultIntent.putExtra("master", key_master.getText().toString()); // Get the text first, else it grabs the id and converts it to string
        resultIntent.putExtra("security", pw_security.getText().toString()); // Same here.
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public void import_settings(View view) {
        // Imports the settings previously saved.
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String master = sharedPref.getString("masterkey", "0");
        String pw = sharedPref.getString("pw", "0");

        // Distribute settings.
        Intent resultIntent = new Intent();
        resultIntent.putExtra("master", master); // Get the text first, else it grabs the id and converts it to string
        resultIntent.putExtra("security", pw); // Same here.
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
