package com.sarfaraj.newsapp.Models;

public class NewsItemModel {
    String imgUrl,title,desc,articleLink;

    public NewsItemModel(String imgUrl, String title, String desc,String articleLink) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.desc = desc;
        this.articleLink = articleLink;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }
}
