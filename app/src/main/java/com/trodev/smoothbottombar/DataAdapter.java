package com.trodev.smoothbottombar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    ArrayList<String> name ;
    ArrayList<String> details;
    ArrayList<String> userImg;
    Context context;

    public DataAdapter(ArrayList<String> name, ArrayList<String> details, ArrayList<String> userImg, Context context) {
        this.name = name;
        this.details = details;
        this.userImg = userImg;
        this.context = context;
    }

    @NonNull
    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.MyViewHolder holder, int position) {

        holder.nameTv.setText(name.get(position));
      //  holder.detailsTv.setText(details.get(position));

        Glide
                .with(context)
                .load(userImg.get(position))
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(holder.imageIv);

        holder.cardMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullViewActivity.class);
                intent.putExtra("name", name.get(position));
                intent.putExtra("details", details.get(position));
                intent.putExtra("img", userImg.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv, detailsTv;
        CardView cardMc;
        ImageView imageIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            detailsTv = itemView.findViewById(R.id.detailsTv);
            cardMc = itemView.findViewById(R.id.cardMc);
            imageIv = itemView.findViewById(R.id.imageIv);

        }
    }
}
