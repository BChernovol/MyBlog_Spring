package com.bchernovol.blog1.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String anons;
    @Column(name = "full_text")
    private String fullText;
    @Column(name = "vievs")
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String full_text) {
        this.fullText = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Post(){

    }

    public Post(String title,String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }

}
