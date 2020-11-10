package com.example.blog.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "blog")
public class BlogClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String postName;
    private String content_blog;
    private String dateCreate;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;

    public BlogClass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getContent_blog() {
        return content_blog;
    }

    public void setContent_blog(String content_blog) {
        this.content_blog = content_blog;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
