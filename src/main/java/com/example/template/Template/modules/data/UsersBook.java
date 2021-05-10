package com.example.template.Template.modules.data;

import com.example.template.Template.app.data.UsersDTO;

import javax.persistence.*;

@Entity
@Table(name="users_book")
public class UsersBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name="idBook")
    private DAOBook idBook;
    @ManyToOne()
    @JoinColumn(name="idUser")
    private UsersDTO idUser;

    public UsersBook() {
    }

    public UsersBook(int id, DAOBook idBook, UsersDTO idUser) {
        this.id = id;
        this.idBook = idBook;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DAOBook getIdBook() {
        return idBook;
    }

    public void setIdBook(DAOBook idBook) {
        this.idBook = idBook;
    }

    public UsersDTO getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersDTO idUser) {
        this.idUser = idUser;
    }
}
