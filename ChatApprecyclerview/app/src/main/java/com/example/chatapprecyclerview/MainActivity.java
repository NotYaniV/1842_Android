package com.example.chatapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tom(View view) {
        Intent tomIntent = new Intent(MainActivity.this,tomActivity.class);
        startActivity(tomIntent);
    }

    public void jerry(View view) {
        Intent jerryIntent = new Intent(MainActivity.this,jerryActivity.class);
        startActivity(jerryIntent);
    }
}