package com.example.itcurces.model;

public class Course {

    int id, category;
    String img,title,date,color,text,Price;

    public Course(int id, String img, String title, String date, String color, String text, int category,String Price){
        this.id = id;
        this.img =img;
        this.title = title;
        this.date = date;
        this.color = color;
        this.text = text;
        this.category = category;
        this.Price = Price;
    }

    public String getTextMany() {
        return Price;
    }

    public void setTextMany(String textMany) {
        this.Price = textMany;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }
    public void setId(){
        this.id = id;
    }

    public String getImg() {
        return img;
    }
    public void setImg(){
        this.img = img;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(){
        this.title = title;
    }

    public String getDate() {
        return date;
    }
    public void setDate(){
        this.date = date;
    }

    public String getColor() {
        return color;
    }
    public void setColor(){
        this.color = color;
    }

}
