package com.example.chatapprecyclerview;


import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class tomActivity extends AppCompatActivity implements Serializable {
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager manager;
    public RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tom);

        final ArrayList<secondMessage> texts= secondMessageStore.getInstance().msgText;
        final ArrayList<firstMessage> msg= firstMessageStore.getInstance().msgText;

        recyclerView= (RecyclerView) findViewById(R.id.tom_view);
        manager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        final  MaterialButton sendButton= (MaterialButton) findViewById(R.id.msg_send_tom);
        final TextInputEditText message= (TextInputEditText) findViewById(R.id.text_tom);

        sendButton.setOnClickListener(view -> {
            String chat = Objects.requireNonNull(message.getText()).toString();
            if (chat.length() != 0){
                texts.add(new secondMessage(jAdapter.MESSAGE_TYPE_IN, chat));
                msg.add(new firstMessage(tAdapter.MESSAGE_TYPE_OUT, chat));
                message.setText("");
                message.clearFocus();
                adapter = new tAdapter(msg);
                recyclerView.setAdapter(adapter);
            }
            else return ;

        });
        adapter = new tAdapter(msg);
        recyclerView.setAdapter(adapter);


    }

/*    public static class firstMessage {
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
    public static class secondMessage {
        int name;
        public String text;
        public secondMessage(int name, String text){
            this.name = name;
            this.text = text;
        }
    }
    public static class secondMessageStore {
        private static secondMessageStore instance;
        final ArrayList<secondMessage> text = new ArrayList<>();
        private void secondMessageStore(){}
        static secondMessageStore getInstance(){
            if( instance == null ) {
                instance = new secondMessageStore();
            }
            return instance;
        }
    }
    */
}
