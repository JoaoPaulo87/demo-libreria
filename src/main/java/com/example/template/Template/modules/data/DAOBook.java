package com.example.template.Template.modules.data;

import com.example.template.Template.app.data.UsersDTO;
import org.apache.catalina.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class DAOBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="category")
    private String category;
    @Column(name="is_borrowed")
    private boolean isBorrowed;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne
    @JoinTable(name="users", joinColumns = @JoinColumn(name="id"))
    private UsersDTO userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int isQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UsersDTO getUserId() {
        return userId;
    }

    public void setUserId(UsersDTO userId) {
        this.userId = userId;
    }

    public DAOBook() {
    }

    public DAOBook(long id,
                   String title,
                   String author,
                   String category,
                   boolean isBorrowed,
                   int quantity,
                   UsersDTO userId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = isBorrowed;
        this.quantity = quantity;
        this.userId = userId;
    }
}