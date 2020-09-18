package com.example.intent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.intent.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent= getIntent();
        String message= intent.getStringExtra(MainActivity3.EXTRA_MESSAGE3);

        EditText editText= findViewById(R.id.edittext1);
        editText.setText(message);
    }


    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivityTwo.class);
        EditText editText = findViewById(R.id.edittext1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}