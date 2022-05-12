package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.module.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class RequestManager {
    Context context;
    Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://dummyapi.io/data/v1/post/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getPost(OnFetchDataListener<Post> listener, String app_id){
        CallPostApi callPostApi= retrofit.create(CallPostApi.class);
        Call<Post> call= callPostApi.callHeadlines(context.getString(R.string.api_key));
        try{
            call.enqueue(new Callback<Post>() {
                @Override
                public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
                    }
                    if (response.body() != null) {
                        listener.onFetchData(response.body().getDataList(), response.message());
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Post> call,@NonNull Throwable t) {
                    listener.onError("request filed");
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public RequestManager(Context context){
        this.context= context;
    }
    public interface CallPostApi {
        @GET("top_headlines")
        Call<Post> callHeadlines(
                @Query("app-id") String app_id
        );
    }
}
