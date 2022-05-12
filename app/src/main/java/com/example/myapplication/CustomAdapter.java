package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.module.data;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
   private final Context context;
   private final List<data> headlines;
   private SelectListener listener;
    public CustomAdapter(List<data> headlines,Context context, SelectListener listener) {
        this.headlines = headlines;
        this.context= context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.text_post.setText(headlines.get(position).getText());
        holder.text_title_1.setText(headlines.get(position).getOwner().getTitle());
        holder.text_title_2.setText(headlines.get(position).getOwner().getFirstName());
        holder.text_title_3.setText(headlines.get(position).getOwner().getLastName());
        holder.text_source.setText(headlines.get(position).getPublishDate());
        if(headlines.get(position).getOwner().getPicture()!=null){
            Picasso.get().load(headlines.get(position).getOwner().getPicture()).into(holder.picture);
        }
        if(headlines.get(position).getImage()!=null){
            Picasso.get().load(headlines.get(position).getImage()).into(holder.img_headline);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnPostClicked(headlines.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
