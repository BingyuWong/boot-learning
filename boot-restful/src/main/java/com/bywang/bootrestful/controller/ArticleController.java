package com.bywang.bootrestful.controller;

import com.bywang.bootrestful.common.AjaxResponse;
import com.bywang.bootrestful.model.Article;
import com.bywang.bootrestful.model.Reader1;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;




/**
 * @description: ArticleController
 * @author: bywang
 * @date: 2022-03-10
 **/
@RestController
@Slf4j
@RequestMapping("/api/v1")

public class ArticleController {

    /**
     * 获取一篇Article，使用GET方法,根据id查询一篇文章
     *
     * @param id id
     * @return AjaxResponse
     */
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        Reader1[] readers = {
                Reader1.builder().name("aaa").age(12).build(), Reader1.builder().name("bbb").age(13).build()
        };
        //List<Reader> readerList = Arrays.of( Reader1.builder().name("aaa").age(12).build(), Reader.builder().name("bbb").age(13).build());


        Article article = Article.builder().id(id).author("mqxu").content("SpringBoot 从青铜到王者").title("SpringBoot").createTime(new Date()).build();
        log.info("article:" + article);
        return AjaxResponse.success(article);
    }

    /**
     * 增加一篇Article ，使用POST方法(RequestBody方式接收参数)
     *
     * @param article article
     * @param aaa     aaa
     * @return AjaxResponse
     */
//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(@RequestBody Article article, @RequestHeader String aaa) {
//        log.info("saveArticle:" + article);
//        log.info("请求头aaa:" + aaa);
//        return AjaxResponse.success(article);
//    }

    /**
     * 增加一篇Article ，使用POST方法(RequestParam方式接收参数
     *
     * @param author     author
     * @param title      title
     * @param content    content
     * @param createTime createTime
     * @return AjaxResponse
     */
//    @PostMapping("/articles")
//    public AjaxResponse saveArticle(@RequestParam String author, @RequestParam String title, @RequestParam String content, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam Date createTime) {
//        log.info("saveArticle:" + author);
//        log.info("saveArticle:" + title);
//        log.info("saveArticle:" + content);
//        log.info("saveArticle:" + createTime);
//        return AjaxResponse.success();
//    }

    /**
     * 更新一篇Article，使用PUT方法，以id为主键进行更新
     *
     * @param article article
     * @return AjaxResponse
     */
    @PutMapping("/articles")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            log.error("没有id");
            //article.id是必传参数，因为通常根据id去修改数据
        }
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    /**
     * 删除一篇Article，使用DELETE方法，参数是id
     *
     * @param id id
     * @return AjaxResponse
     */
    @DeleteMapping("/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }
}
