package com.example.template.Template.modules.repository;


import com.example.template.Template.modules.data.UsersBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedRepository extends JpaRepository<UsersBook, Integer> {

}
