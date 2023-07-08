package com.trodev.smoothbottombar;

public class ModelClass {

    public String name, description, date, img;


    public ModelClass(String name, String description, String date, String img) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.img = img;
    }

    public ModelClass() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
