package com.example.ung_dung_muon_sach.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String book_name;
    private Integer book_numbers;

    public BookApplication() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getBook_numbers() {
        return book_numbers;
    }

    public void setBook_numbers(Integer book_numbers) {
        this.book_numbers = book_numbers;
    }
}
