package com.example.demo.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Controller
public class PostController {
    private PostService postService;
    PostController(){
        this.postService = new PostService();
    }

    //CSR : 사용자에게 data return
    @GetMapping("/csr/json") //전체 url에다가 localhost:8080/csr/json치고 들어오면 해당 함수와 매핑
    @ResponseBody //json으로 데이터를 받을 때
    public List<Post> findAll(){
        return this.postService.findAll();
    }

    //SSR : 사용자에게 data가 들어간 화면 return
    @GetMapping("/ssr")
    public String findAllSsr(Model model){
        List<Post> posts = postService.findAll();
        //model을 통해 data를 html에 넣어주기
        model.addAttribute("posts", posts); //"key-value" => "posts-posts"
        return "post_list";
    }
}
