package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.entity.BookApplication;
import com.example.ung_dung_muon_sach.repository.BookRepository;
import com.example.ung_dung_muon_sach.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public Page<BookApplication> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(BookApplication bookApplication) {

    }
}
