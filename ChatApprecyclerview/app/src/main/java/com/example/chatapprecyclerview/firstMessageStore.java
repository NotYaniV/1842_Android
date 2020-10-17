package com.example.chatapprecyclerview;
import java.util.ArrayList;

public class firstMessageStore {
    final ArrayList<firstMessage> msgText = new ArrayList<>();

    private firstMessageStore(){}

    static firstMessageStore getInstance(){
        if( instance == null ){
            instance = new firstMessageStore();

        }
        return instance;
    }
    private static firstMessageStore instance;
}
