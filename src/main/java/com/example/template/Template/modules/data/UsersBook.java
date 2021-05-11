package com.example.template.Template.modules.data;

import com.example.template.Template.app.data.UsersDTO;

import javax.persistence.*;

@Entity
@Table(name="users_book")
public class UsersBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne()
    @JoinColumn(name="id_book")
    private DAOBook id_book;
    @ManyToOne()
    @JoinColumn(name="id_user")
    private UsersDTO id_user;

    public UsersBook() {
    }

    public UsersBook(int id, DAOBook id_book, UsersDTO id_user) {
        this.id = id;
        this.id_book = id_book;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DAOBook getIdBook() {
        return id_book;
    }

    public void setIdBook(DAOBook id_book) {
        this.id_book = id_book;
    }

    public UsersDTO getIdUser() {
        return id_user;
    }

    public void setIdUser(UsersDTO id_user) {
        this.id_user = id_user;
    }
}
