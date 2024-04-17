package com.example.itcurces.model;

public class Category {
    int id;
    String title;

    public Category(int id, String title){
        this.id = id;
        this.title = title;
    }
    public int getId(){
        return id;
    }
    public void setId(){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }
}
