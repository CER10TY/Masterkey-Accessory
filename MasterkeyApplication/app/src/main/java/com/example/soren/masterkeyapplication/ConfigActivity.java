package com.example.soren.masterkeyapplication;

import android.app.Activity;
import android.content.Intent;
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
        Intent resultIntent = new Intent();
        resultIntent.putExtra("master", key_master.getText().toString()); // Get the text first, else it grabs the id and converts it to string
        resultIntent.putExtra("security", pw_security.getText().toString()); // Same here.
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
