package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapterlist extends RecyclerView.Adapter<Adapterlist.Holder>  {
    ArrayList<Model> list ;

    public void setList(ArrayList<Model> list) {
        this.list = list;
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent , false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.text2.setText(list.get(position).getName());
        holder.text1.setText(list.get(position).getId()+"");
    }

    @Override
    public int getItemCount() {
        return list.size()  ;
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView text1 ;
        TextView text2 ;

        public Holder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text_loction);
            text2 = itemView.findViewById(R.id.text_number);

        }
    }
}

