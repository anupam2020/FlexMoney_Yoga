package com.sbdev.flexmoney_yoga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    ArrayList<UsersModel> arrayList;
    Context context;

    public UsersAdapter(ArrayList<UsersModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.users_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

        UsersModel model=arrayList.get(holder.getAdapterPosition());
        holder.name.setText(model.getName());
        holder.date.setText(model.getDate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView name,date;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.usersNameTV);
            date=itemView.findViewById(R.id.usersDateTV);

        }
    }

}
