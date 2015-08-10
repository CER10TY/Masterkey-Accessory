package com.example.soren.masterkeyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String masterkey;
    public static String securitypw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Start ConfigActivity.java
            Intent i = new Intent(MainActivity.this, ConfigActivity.class);
            startActivityForResult(i, 1);
        }
        if (id == R.id.action_reset) {
            // This is a menu item to reset the password prompt, the info text (where the PW is shown) and everything else.
            EditText pwPrompt = (EditText) findViewById(R.id.enterPW);
            pwPrompt.setText("");
            TextView prompt = (TextView) findViewById(R.id.info_text);
            prompt.setText("Information reset!");
        }

        return super.onOptionsItemSelected(item);
    }

    public void view_password(View view) {
        // If correct PW was entered, then the Master Key will be shown.
        EditText pwPrompt = (EditText) findViewById(R.id.enterPW);
        String text = String.valueOf(pwPrompt.getText());
        if (text.equals(securitypw)) {
            TextView prompt = (TextView) findViewById(R.id.info_text);
            prompt.setText(masterkey); // Show password for Master Key application.
            // Check if no view has focus: Hides soft keyboard.
            View cView = this.getCurrentFocus();
            if (cView != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } else {
            TextView prompt = (TextView) findViewById(R.id.info_text); // Get info text prompt down at the bottom.
            prompt.setText("Either no password has been set or it's wrong, try again."); // Prompt user to try again since it's the wrong password.
            pwPrompt.setText(""); // Empty password
            // Check if no view has focus: Hides soft keyboard.
            View cView = this.getCurrentFocus();
            if (cView != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (1) : {
                if (resultCode == ConfigActivity.RESULT_OK) {
                    masterkey = data.getStringExtra("master");
                    securitypw = data.getStringExtra("security");
                }
                break;
            }
        }
    }
}
