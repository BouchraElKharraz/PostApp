package com.example.myapplication.module;

import java.io.Serializable;
import java.util.List;

public class data implements Serializable {
    String id;
    String image;
    int likes;
    List<String> tags;
    String text;
    String publishDate;
    owner owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags= tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public com.example.myapplication.module.owner getOwner() {
        return owner;
    }

    public void setOwner(com.example.myapplication.module.owner owner) {
        this.owner = owner;
    }
}
