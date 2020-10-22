package com.example.blog.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name= "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCategory;
    private  String nameCategory;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<BlogClass> blogClassList;

    public Category() {
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<BlogClass> getBlogClassList() {
        return blogClassList;
    }

    public void setBlogClassList(List<BlogClass> blogClassList) {
        this.blogClassList = blogClassList;
    }
}
