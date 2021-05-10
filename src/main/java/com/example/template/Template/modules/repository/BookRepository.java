package com.example.template.Template.modules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.template.Template.modules.data.DAOBook;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<DAOBook, Long> {
    public DAOBook findByTitle(String title);
    public DAOBook findByCategory(String category);
    public ArrayList<DAOBook> findByIs_borrowed(boolean borrowed);
}