package com.example.chatapprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class tAdapter extends RecyclerView.Adapter {
    ArrayList<firstMessage> mDataset;
    public static final int MESSAGE_TYPE_IN = 1;
    public static final int MESSAGE_TYPE_OUT = 2;
    public tAdapter(ArrayList<firstMessage> msg) {
        mDataset = msg;
    }

    private class IncomingViewHolder extends RecyclerView.ViewHolder{
        public MaterialTextView textView;

        public IncomingViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.tom_income);
        }
        void bind(int position) {
            firstMessage firstMessage = mDataset.get(position);
            textView.setText(firstMessage.text);

        }
    }

    private class OutgoingViewHolder extends RecyclerView.ViewHolder {

        public MaterialTextView textView;
        public OutgoingViewHolder(final View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.jerry_income);

        }
        void bind(int position) {
            firstMessage firstMessage = mDataset.get(position);
            textView.setText(firstMessage.text);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        if (viewType == MESSAGE_TYPE_IN){
            final IncomingViewHolder incomingViewHolder = new IncomingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_income_tom, parent, false));
            return incomingViewHolder;
        }
        else{
            final OutgoingViewHolder outgoingViewHolder = new OutgoingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_income_jerry, parent, false));
            return outgoingViewHolder;
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(MESSAGE_TYPE_IN == mDataset.get(position).name){
            ((IncomingViewHolder) holder).bind(position);
        }
        else ((OutgoingViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        final int size = mDataset.size();
        return size;
    }

    @Override
    public int getItemViewType(int position) {
       final int name = mDataset.get(position).name;
        return name;
    }


}
