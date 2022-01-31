package com.bchernovol.blog1.controller;

import com.bchernovol.blog1.models.Post;
import com.bchernovol.blog1.models.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;


@Controller
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String BlogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String BlogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String BlogPostAdd(@RequestParam String title, @RequestParam String anons,
                              @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons,full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }
    @GetMapping("/blog/{id}")
    public String BlogDetails(@PathVariable(value="id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        Iterable<Post> res = post.map(Arrays::asList).orElse(Collections.emptyList());
        model.addAttribute("post", res);
        return "blog-details";
    }

}
