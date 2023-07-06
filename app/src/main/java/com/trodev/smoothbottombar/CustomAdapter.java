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

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private List<ModelClass> list;

    public CustomAdapter(Context context, List<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*set data on views*/
        holder.nameTv.setText("Name: " + list.get(position).name);
        holder.descriptionTv.setText("Description: " + list.get(position).description);
        holder.dateTv.setText("Date: " + list.get(position).date);

        Glide
                .with(context)
                .load(list.get(position).getImg())
                .centerCrop()
                .placeholder(R.drawable.ic_hone)
                .into(holder.imageIv);


        /*on click listener*/
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FullDataActivity.class);
                intent.putExtra("name", list.get(position).name);
                intent.putExtra("des",list.get(position).description);
                intent.putExtra("date", list.get(position).date);
                intent.putExtra("img", list.get(position).getImg());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv, descriptionTv, dateTv;
        ImageView imageIv;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /*init views*/
            nameTv = itemView.findViewById(R.id.nameTv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            dateTv = itemView.findViewById(R.id.dateTv);
            imageIv = itemView.findViewById(R.id.imageIv);
            cardView = itemView.findViewById(R.id.cardMc);

        }
    }
}
