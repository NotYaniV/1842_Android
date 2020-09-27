package com.example.materialapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.materialapp.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;


public class MainActivity2 extends AppCompatActivity {

    private Button mDatePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        TextInputEditText textInput= findViewById(R.id.goa);
        textInput.setFocusable(false);

        MaterialTextView nametext=(MaterialTextView) findViewById(R.id.nametxt);
        Intent intent= getIntent();
        String Name= getIntent().getStringExtra("name");
        nametext.setText(Name);

        mDatePicker= findViewById(R.id.datebtn);
        final MaterialTextView dateview= (MaterialTextView) findViewById(R.id.birthtxt);

        MaterialDatePicker.Builder builder= MaterialDatePicker.Builder.datePicker();

        final MaterialDatePicker materialDatePicker= builder.build();

        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(),"Date_Picker");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                dateview.setText(materialDatePicker.getHeaderText());

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}