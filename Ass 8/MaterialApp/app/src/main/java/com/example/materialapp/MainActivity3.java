package com.example.materialapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity3 extends Fragment {

    private Button mDatePicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main3,container,false);
        TextInputEditText textInput = view.findViewById(R.id.goa);
        textInput.setFocusable(false);

        mDatePicker = view.findViewById(R.id.date_btn);
        final MaterialTextView date_view = (MaterialTextView) view.findViewById(R.id.birthday_txt);

        MaterialTextView nameText = view.findViewById(R.id.name);
        nameText.setText("name");

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();

        final MaterialDatePicker materialDatePicker = builder.build();

        mDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getFragmentManager(),"Date_Picker");

            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                date_view.setText(materialDatePicker.getHeaderText());

            }
        });
        getActivity().setTitle("Address");
        setHasOptionsMenu(true);
        return view;
    }
}