package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
     TextView text_title_1,text_title_2,text_title_3,text_source,text_post,tag_1,tag_2,tag_3;
     ImageView picture,img_headline;
     CardView cardView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        text_title_1=itemView.findViewById(R.id.text_title_1);
        text_title_2=itemView.findViewById(R.id.text_title_2);
        text_title_3=itemView.findViewById(R.id.text_title_3);
        text_source=itemView.findViewById(R.id.text_source);
        text_post=itemView.findViewById(R.id.text_post);
        picture=itemView.findViewById(R.id.picture);
        img_headline=itemView.findViewById(R.id.img_headline);
        tag_1=itemView.findViewById(R.id.tag_1);
        tag_2=itemView.findViewById(R.id.tag_2);
        tag_3=itemView.findViewById(R.id.tag_3);
        cardView=itemView.findViewById(R.id.main_container);
    }
}
