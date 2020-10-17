package com.example.chatapprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import static com.example.chatapprecyclerview.tAdapter.MESSAGE_TYPE_OUT;

public class jAdapter extends RecyclerView.Adapter {
    ArrayList<secondMessage> mDataset;
    public static final int MESSAGE_TYPE_IN = 1;
    public static final int MESSAGE_TYPE_OUT = 2;

    public jAdapter(ArrayList<secondMessage> texts) {

        mDataset = texts;

    }

    private class IncomingViewHolder extends RecyclerView.ViewHolder{
        public MaterialTextView textView;

        public IncomingViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tom_income);
        }
        void bind(int position) {
            secondMessage secondMessage = mDataset.get(position);
            textView.setText(secondMessage.text);

        }
    }

    private class OutgoingViewHolder extends RecyclerView.ViewHolder {

        public MaterialTextView textView;
        public OutgoingViewHolder(final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.jerry_income);
        }
        void bind(int position) {
            secondMessage secondMessage = mDataset.get(position);
            textView.setText(secondMessage.text);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        if (MESSAGE_TYPE_IN == viewType){
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
    public int getItemViewType(int position) {

        final int name = mDataset.get(position).name;
        return name;
    }

    @Override
    public int getItemCount() {

        final int size = mDataset.size();
        return size;
    }



}
