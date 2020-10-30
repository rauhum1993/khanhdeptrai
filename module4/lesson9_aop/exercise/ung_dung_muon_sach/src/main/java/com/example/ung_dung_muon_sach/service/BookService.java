package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.entity.BookApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<BookApplication> findAll(Pageable pageable);

    void save(BookApplication bookApplication);
}
