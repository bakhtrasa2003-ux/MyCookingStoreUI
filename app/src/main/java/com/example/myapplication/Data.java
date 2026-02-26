package com.example.myapplication;
public class Data {

    private String title;

    private String subTitle;

    private int image;


    public Data(String title, String subTitle,int image) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
    }

    public String getTitle() {

        return title;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {

        this.image = image;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getSubTitle() {

        return subTitle;
    }

    public void setSubTitle(String subTitle) {

        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", image=" + image +
                '}';
    }
}
