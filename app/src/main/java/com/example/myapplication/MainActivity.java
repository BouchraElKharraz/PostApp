package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.module.Post;
import com.example.myapplication.module.data;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{
Context context;
RecyclerView recyclerView;
CustomAdapter adapter;
ProgressDialog dialog;
SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView= findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Fetching post of"+ query);
                dialog.show();
                RequestManager manager=new RequestManager(MainActivity.this );
                manager.getPost(listener,context.getString(R.string.api_key));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching posts");
        dialog.show();
        RequestManager manager=new RequestManager(this );
        manager.getPost(listener,context.getString(R.string.api_key));
    }
    private final OnFetchDataListener<Post> listener= new OnFetchDataListener<Post>() {
        @Override
        public void onFetchData(List<data> list, String message) {
            if (list.isEmpty()){
                Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
            }
            else{
                showPosts(list);
                dialog.dismiss();
            }

        }

        @Override
        public void onError(String message) {
            Toast.makeText(context, "An Error Occured!!", Toast.LENGTH_SHORT).show();
        }
    };
    private void showPosts(List<data> list){
        recyclerView= findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter= new CustomAdapter(list, this,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnPostClicked(data data) {
        startActivity(new Intent(MainActivity.this,DefoultActivity.class));
    }
}