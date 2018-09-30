package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Article;
import com.example.demo.page.ArticlePage;
import com.example.demo.page.PageInfo;
import com.example.demo.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
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

    @ResponseBody
    @RequestMapping(value = "/all")
    public String all() {
        System.out.println(articleService.find(1));
        List<Article> list = articleService.select();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(String title, Integer page, Integer pageSize) {
        ArticlePage articlePage = new ArticlePage();
        if (StringUtils.isNotBlank(title))
            articlePage.setTitle(title);
        if (page != null)
            articlePage.setCurrPageNo(page);
        if (pageSize != null)
            articlePage.setLimit(pageSize);
        articlePage = articleService.queryByCondition(articlePage);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(articlePage.getTotal());
        pageInfo.setLastPage(articlePage.getPageNos());
        pageInfo.setPage(articlePage.getCurrentPage());
        pageInfo.setPageSize(articlePage.getLimit());
        pageInfo.setPageNumbers(articlePage.getNavigatePageNos());

        ModelAndView mv = new ModelAndView("article-index");
        mv.addObject("articles", articlePage.getDatas());
        mv.addObject("pageInfo", pageInfo);
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
