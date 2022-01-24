package com.sarfaraj.newsapp.Models;

public class CategoryItemModel {

    String category_text,imgUrl;

    public CategoryItemModel(String category_text, String imgUrl) {
        this.category_text = category_text;
        this.imgUrl = imgUrl;
    }

    public String getCategory_text() {
        return category_text;
    }

    public void setCategory_text(String category_text) {
        this.category_text = category_text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
