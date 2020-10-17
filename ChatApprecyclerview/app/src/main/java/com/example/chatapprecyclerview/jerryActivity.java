package com.example.chatapprecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;

public class jerryActivity extends AppCompatActivity implements Serializable {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerry);

        final ArrayList<firstMessage> texts = firstMessageStore.getInstance().msgText;
        final ArrayList<secondMessage> text2 = secondMessageStore.getInstance().msgText;

        recyclerView = (RecyclerView) findViewById(R.id.tom_view);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        final MaterialButton sendButton = (MaterialButton) findViewById(R.id.msg_send_jerry);
        final TextInputEditText message = (TextInputEditText) findViewById(R.id.text_jerry);


        sendButton.setOnClickListener(view -> {

            String chat = message.getText().toString();
            if (chat.length() != 0){
                texts.add(new firstMessage(tAdapter.MESSAGE_TYPE_IN, chat));
                text2.add(new secondMessage(jAdapter.MESSAGE_TYPE_OUT, chat));
                message.setText("");

                message.clearFocus();
                adapter = new jAdapter(text2);
                recyclerView.setAdapter(adapter);
            }
            else return ;
        });
        adapter = new jAdapter(text2);
        recyclerView.setAdapter(adapter);
    }
    /*
  private static class firstMessage{
        int name;
        public String text;
        public firstMessage(int name, String text){
            this.name = name;
            this.text = text;
        }
    }
  public static  class firstMessageStore{
        private static firstMessageStore instance;
        final ArrayList<firstMessage> text = new ArrayList<>();
        private void firstMessageStore(){}
        static firstMessageStore getInstance(){
            if( instance == null ) {
                instance = new firstMessageStore();
            }
            return instance;
        }
    }
  public static class secondMessage  {
        int name;
        public String text;
        public secondMessage(int name, String text){
            this.name = name;
            this.text = text;
        }
    }
   public static class secondMessageStore {
        private static secondMessageStore instance;
        final ArrayList<secondMessageStore> text = new ArrayList<>();
        private void secondMessageStore(){}
        static secondMessageStore getInstance(){
            if( instance == null ) {
                instance = new secondMessageStore();
            }
            return instance;
        }
    }*/
}
