package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        List<Article> articles = articleService.select();
        ModelAndView mv = new ModelAndView("article-index");
        mv.addObject("articles", articles);
        return mv;
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "article-add";
    }

    @ResponseBody
    @RequestMapping(value = "/addData")
    public String addData(Article article) {
        article.setUid(1);
        article.setPic("https://www.baidu.com/img/baidu_jgylogo3.gif");
        article.setCreated_at(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Integer num = articleService.insert(article);
        System.out.println(num);

        Map map = new HashMap();
        map.put("status", 1);
        map.put("info", "保存成功");
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(int id) {
        Article article = articleService.find(id);
        ModelAndView mv = new ModelAndView("article-edit");
        mv.addObject("row", article);
        return mv;
    }

    @RequestMapping(value = "/editData")
    public String editData(Article article) {
        System.out.println(article);
        int res = articleService.update(article);
        System.out.println(res);
        return "redirect:/article/index";
    }

    @RequestMapping(value = "/del")
    public String del(int id) {
        int res = articleService.del(id);
        System.out.println(res);
        return "redirect:/article/index";
    }
}
