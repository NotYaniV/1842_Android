package com.example.snackbar;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MaterialTextView textView;
    MaterialButton delButton;
    ArrayList<Friends> data;
    Friends name;
    public Adapter(ArrayList<Friends> friendsList){
        data = friendsList;
    }
    private class ListView extends RecyclerView.ViewHolder{

        public ListView(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name_list);
            delButton = itemView.findViewById(R.id.delete);
        }
        void bind(final int position) {
            final Friends friendsList = data.get(position);
            textView.setText(friendsList.friends);
            delButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = new Friends(data.get(position).friends);
                    data.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,data.size());
                    notifyDataSetChanged();

                    Snackbar.make(view,"DELETED ITEM",Snackbar.LENGTH_LONG)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    data.add(position,name);
                                    notifyItemInserted(position);
                                    notifyItemRangeChanged(position,data.size());
                                    notifyDataSetChanged();
                                }
                            }).show();
                }
            });
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListView(LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListView)holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

