package com.example.template.Template.modules.controller;

import com.example.template.Template.app.config.swagger.ControllerDocumentation;
import com.example.template.Template.modules.data.UsersBook;
import com.example.template.Template.modules.service.BorrowedService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerDocumentation
@RequestMapping("/api/borrowed")
public class BorrowedController {

    @Autowired
    BorrowedService borrowedService;


    @PostMapping("/return_book")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void>returnBook(@RequestParam(name="usersbook_id") int usersBookID) {
        this.borrowedService.returnBook(usersBookID);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UsersBook>> findBooksBorrowedByUser(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(this.borrowedService.findAllByUserId(id));
    }

    @PostMapping("/borrow_book")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<UsersBook>borrowBook(@RequestParam(name="id_user") Long userID,
                                               @RequestParam(name="id_book") Long bookID) {
        return ResponseEntity.ok(this.borrowedService.borrowBook(userID, bookID));
    }

//    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public ResponseEntity<List<UsersBook>> findBooksBorrowedByUser(@PathVariable(name="id") int id){
//        return ResponseEntity.ok(this.borrowedService.findBooksBorrowedByUser(id));
//    }
}
