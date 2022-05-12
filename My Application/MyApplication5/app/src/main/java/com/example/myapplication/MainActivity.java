package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.myapplication.module.Post;
import com.example.myapplication.module.data;

import java.util.List;

public class MainActivity extends AppCompatActivity {
Context context;
RecyclerView recyclerView;
CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestManager manager=new RequestManager(this );
        manager.getPost(listener,context.getString(R.string.api_key));
    }
    private final OnFetchDataListener<Post> listener= new OnFetchDataListener<Post>() {
        @Override
        public void onFetchData(List<data> list, String message) {
            showPosts(list);
        }

        @Override
        public void onError(String message) {

        }
    };
    private void showPosts(List<data> list){
        recyclerView= findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter= new CustomAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }
}