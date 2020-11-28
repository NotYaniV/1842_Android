package com.example.materialapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity2 extends Fragment {
    Button sendbtn ,readbtn;
    TextInputEditText name1,email,phone,password,rePassword1;
    Database db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main2,container,false);
        sendbtn = (Button) view.findViewById(R.id.send);
        readbtn = (Button) view.findViewById(R.id.read);
        name1= view.findViewById(R.id.name);
        email= view.findViewById(R.id.email);
        phone= view.findViewById(R.id.phone);
        password= view.findViewById(R.id.password);
        rePassword1= view.findViewById(R.id.rePassword);

        db = new Database(getContext());

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name1.getText().toString();
                String mail = email.getText().toString();
                String no = phone.getText().toString();
                String pass =  password.getText().toString();
                String repass = rePassword1.getText().toString();

                Boolean data = db.insertData(name,mail,no,pass,repass);
                if(data==true){
                    Toast.makeText(getContext(),"User Registered Successfully", Toast.LENGTH_SHORT).show();
                    name1.setText("");
                    email.setText("");
                    phone.setText("");
                    password.setText("");
                    rePassword1.setText("");

                }else{
                    Toast.makeText(getContext(),"Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor temp = db.readData();
                if(temp.getCount()==0){
                    Toast.makeText(getContext(),"Database has no User's",Toast.LENGTH_SHORT).show();
                    return;
                }
                while(temp.moveToNext()){
                    name1.setText(temp.getString(0));
                    email.setText(temp.getString(1));
                    phone.setText(temp.getString(2));
                    password.setText(temp.getString(3));
                    rePassword1.setText(temp.getString(4));
                }
            }
        });
        getActivity().setTitle("Login");
        return view;
    }


}