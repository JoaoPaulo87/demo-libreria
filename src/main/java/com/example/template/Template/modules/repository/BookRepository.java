package com.example.template.Template.modules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.template.Template.modules.data.DAOBook;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<DAOBook, Long> {
    public DAOBook findByTitle(String title);
    public DAOBook findByCategory(String category);

    List<DAOBook> findAllByCategory(String category);
}