package com.example.template.Template.modules.service;

import com.example.template.Template.modules.data.DAOBook;
import com.example.template.Template.modules.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public DAOBook findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public DAOBook findByCategory(String category){
        return bookRepository.findByCategory(category);
    }

    public ArrayList<DAOBook> findByIs_borrowed(boolean borrowed){
        return (ArrayList<DAOBook>)bookRepository.findAll();
    }
}
