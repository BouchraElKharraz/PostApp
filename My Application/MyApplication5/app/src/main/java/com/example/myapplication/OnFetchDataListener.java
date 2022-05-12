package com.example.myapplication;
import com.example.myapplication.module.data;

import java.util.List;

public interface OnFetchDataListener<Post> {
    void onFetchData(List<data> list, String message);
    void onError(String message);
}
