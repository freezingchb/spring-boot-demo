package com.example.demo.mapper;

import com.example.demo.bean.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    public List<Article> select();

    public Article find(Integer id);

    public Integer insert(Article article);

    public int update(Article article);

    public Integer del(int id);
}
