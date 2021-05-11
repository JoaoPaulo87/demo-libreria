package com.example.template.Template.modules.controller;

import com.example.template.Template.app.config.swagger.ControllerDocumentation;
import com.example.template.Template.modules.data.DAOBook;
import com.example.template.Template.modules.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerDocumentation
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(path = "/category")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<DAOBook>> findByCategory(@RequestParam("category")String category){
        return ResponseEntity.ok(this.bookService.findByCategory(category));
    }

    @GetMapping(path = "/title")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<DAOBook> findByTitle(@RequestParam(name= "title")String title){
        return ResponseEntity.ok(this.bookService.findByTitle(title));
    }

    //Agregar libros.
    @PostMapping(path = "/add_book")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DAOBook> addBook(@RequestBody DAOBook book){
        return ResponseEntity.ok(this.bookService.addBook(book));
    }

    //Borrar libros.
    @DeleteMapping(path = "/return_book/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable(name= "id") Long id){
        this.bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
