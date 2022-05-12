package com.example.myapplication.module;

import java.io.Serializable;
import java.util.List;

public class Post implements Serializable {
    List<data> dataList;

    public List<data> getDataList() {
        return dataList;
    }

    public void setDataList(List<data> dataList) {
        this.dataList = dataList;
    }
}
