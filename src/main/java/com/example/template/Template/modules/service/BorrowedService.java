package com.example.template.Template.modules.service;

import com.example.template.Template.app.data.UsersDTO;
import com.example.template.Template.modules.data.DAOBook;
import com.example.template.Template.modules.data.UsersBook;
import com.example.template.Template.modules.repository.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowedService {

    @Autowired
    BorrowedRepository borrowedRepository;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    public UsersBook findById(int id){
        return this.borrowedRepository.findById(id).orElse(null);
    }

    public UsersBook borrowBook(Long userID, Long bookID){
        UsersBook usersBook = new UsersBook();
        DAOBook daoBook = this.bookService.borrowBook(bookID);
        System.out.println("Returning daobook " + daoBook);

        if (daoBook != null){
            UsersDTO user = this.userService.findById(userID);

            System.out.println("Returning userID " + user);

            usersBook.setIdBook(daoBook);
            usersBook.setIdUser(user);

            System.out.println("Returning usersBook " + usersBook);
            return this.borrowedRepository.save(usersBook);
        }
        else{
            return null;
        }
    }

    public void returnBook(int id){
        UsersBook usersBook = this.borrowedRepository.findById(id).orElse(null);

        if (usersBook != null){
            DAOBook daoBook = usersBook.getIdBook();
            this.bookService.returnBook(daoBook.getId());

            this.borrowedRepository.deleteById(id);
        }
    }
}
