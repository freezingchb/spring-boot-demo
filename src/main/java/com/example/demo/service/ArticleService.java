package com.example.demo.service;

import com.example.demo.bean.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> select() {
        return articleMapper.select();
    }

    public Article find(Integer id) {
        return articleMapper.find(id);
    }

    public int insert(Article article) {
        return articleMapper.insert(article);
    }

    public int update(Article article) {
        return articleMapper.update(article);
    }

    public int del(int id) {
        return articleMapper.del(id);
    }
}
