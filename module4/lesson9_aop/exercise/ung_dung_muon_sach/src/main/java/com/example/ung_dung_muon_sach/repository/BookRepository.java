package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.entity.BookApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookApplication,Integer> {
}
