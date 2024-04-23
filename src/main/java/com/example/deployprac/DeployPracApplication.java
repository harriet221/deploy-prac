package com.example.deployprac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@Controller
public class DeployPracApplication {

    @Autowired
    private ArticleRepository articleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DeployPracApplication.class, args);
    }

    @GetMapping("/")
    @ResponseBody
    public String showMain() {
        return "메인 페이지";
    }

    @GetMapping("/new")
    @ResponseBody
    public Article newArticle() {
        Article article = articleRepository.save(
                articleRepository.save(new Article("제목"))
        );

        return article;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Article> articles() {
        return articleRepository.findAll();
    }
}
