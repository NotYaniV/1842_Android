package com.example.snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity<inner> extends AppCompatActivity {

    private ArrayAdapter<String> listAdapter ;

    RecyclerView recyclerView;
    Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    CoordinatorLayout coordinatorLayout;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getSupportActionBar().hide();
            recyclerView = findViewById(R.id.mainview);
            coordinatorLayout = findViewById(R.id.coordinatorLayout);
            final ArrayList<Friends> friendsList = new ArrayList<>();

            recyclerView= (RecyclerView) findViewById(R.id.mainview);
            layoutManager = new LinearLayoutManager(MainActivity.this);
            recyclerView.setLayoutManager(layoutManager);

            String[] friends = new String[] {
                    "Liam","Noah","William","James","Benjamin","Elijah",
                    "Lucas","Mason","Logan","Alexander","Ethan","Jacob","Michael","Daniel","Henry",
                    "Jackson","Sebastian","Aiden","Matthew"
            };

            for (int i=0;i<friends.length;i++){
                friendsList.add(new Friends(friends[i]));

            }
            friendsList.add(new Friends("Liam"));
            mAdapter = new Adapter(friendsList);
            recyclerView.setAdapter(mAdapter);

    }
    /*
    private void populateRecyclerView(){
        String[] friends = new String[] {
                "Liam","Noah","William","James","Benjamin","Elijah",
                "Lucas","Mason","Logan","Alexander","Ethan","Jacob","Michael","Daniel","Henry",
                "Jackson","Sebastian","Aiden","Matthew"
        };
        stringArrayList.addAll( Arrays.asList(friends) );
        stringArrayList.add("Liam");
        stringArrayList.add("Jerry");
        Collections.sort(stringArrayList);
        mAdapter = new Adapter(stringArrayList);
        recyclerView.setAdapter(mAdapter);
    }*/
}
