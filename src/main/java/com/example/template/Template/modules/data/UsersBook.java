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
    private DAOBook bookId;
    @ManyToOne()
    @JoinColumn(name = "id_user")
    private UsersDTO userId;

    public UsersBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DAOBook getBookId() {
        return bookId;
    }

    public void setBookId(DAOBook bookId) {
        this.bookId = bookId;
    }

    public UsersDTO getUserId() {
        return userId;
    }

    public void setUserId(UsersDTO userId) {
        this.userId = userId;
    }

    public UsersBook(int id, DAOBook bookId, UsersDTO userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
    }
}