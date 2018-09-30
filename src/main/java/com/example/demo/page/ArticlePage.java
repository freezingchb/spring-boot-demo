package com.example.demo.page;

import com.example.demo.bean.Article;

/**
 * 分页
 */
public class ArticlePage extends BasePage<Article> {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
