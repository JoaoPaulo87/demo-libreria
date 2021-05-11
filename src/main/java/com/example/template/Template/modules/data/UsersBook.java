package com.example.template.Template.modules.data;

import com.example.template.Template.app.data.UsersDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="users_book")
@Data
public class UsersBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne()
    @JoinColumn(name = "id_book")
    private DAOBook book;
    @ManyToOne()
    @JoinColumn(name = "id_user")
    private UsersDTO user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DAOBook getBook() {
        return book;
    }

    public void setBook(DAOBook book) {
        this.book = book;
    }

    public UsersDTO getUser() {
        return user;
    }

    public void setUser(UsersDTO user) {
        this.user = user;
    }

    public UsersBook() {
    }

    public UsersBook(int id, DAOBook book, UsersDTO user) {
        this.id = id;
        this.book = book;
        this.user = user;
    }
}