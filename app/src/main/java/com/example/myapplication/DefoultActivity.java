package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.module.data;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DefoultActivity extends AppCompatActivity {
    data data;
    ImageView picture_detail,img_headline_detail;
    TextView text_title_1_detail,text_title_2_detail,text_title_3_detail,text_source_detail,text_post_detail,tag_1_detail,tag_2_detail,tag_3_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defoult);

        text_title_1_detail=findViewById(R.id.text_title_1_detail);
        text_title_2_detail=findViewById(R.id.text_title_2_detail);
        text_title_3_detail=findViewById(R.id.text_title_3_detail);
        text_source_detail=findViewById(R.id.text_source_detail);
        text_post_detail=findViewById(R.id.text_post_detail);
        tag_1_detail=findViewById(R.id.tag_1_detail);
        tag_2_detail=findViewById(R.id.tag_2_detail);
        tag_3_detail=findViewById(R.id.tag_3_detail);
        picture_detail=findViewById(R.id.picture_detail);
        img_headline_detail=findViewById(R.id.img_headline_detail);

        data = (com.example.myapplication.module.data) getIntent().getSerializableExtra("data");

        text_title_1_detail.setText(data.getOwner().getTitle());
        text_title_2_detail.setText(data.getOwner().getFirstName());
        text_title_3_detail.setText(data.getOwner().getLastName());
        text_source_detail.setText(data.getPublishDate());
        text_post_detail.setText(data.getText());
        Picasso.get().load(data.getImage()).into(img_headline_detail);
        Picasso.get().load(data.getOwner().getPicture()).into(picture_detail);

    }
}