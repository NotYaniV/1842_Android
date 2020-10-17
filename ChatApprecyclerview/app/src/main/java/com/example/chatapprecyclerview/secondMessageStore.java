package com.example.chatapprecyclerview;


import java.util.ArrayList;

public class secondMessageStore {
    final ArrayList<secondMessage> msgText = new ArrayList<>();

    private secondMessageStore(){}

    static secondMessageStore getInstance(){
        if( instance == null ){
            instance = new secondMessageStore();

        }
        return instance;
    }
    private static secondMessageStore instance;
}