package com.example.bai_10;

public class Article {

    private String title;
    private String content;
    private int img_cover;
    private int view;

    public Article(String title, String content, int img_cover) {
        this.title = title;
        this.content = content;
        this.img_cover = img_cover;
        this.view = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImgCover() {
        return img_cover;
    }

    public int getView() {
        return view;
    }

    public void increaseView() {
        view++;
    }
}