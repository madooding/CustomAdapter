package com.example.madooding.listview;

import java.io.Serializable;

/**
 * Created by madooding on 9/30/2016 AD.
 */
public class People implements Serializable{

    private String name;
    private int image;
    private String info;

    public People(String name, int image){
        this.name = name;
        this.image = image;
        this.info = "Lorem ipsum mong ko im press de la gret via la gesture num vanh lai embarrased test long text brown fox jumps over my head and also drop a shit while it is jumping. what the hell is that.";
    }


    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getInfo() { return info; }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setInfo(String newInfo) { this.info = newInfo; }
}
