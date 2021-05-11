package com.example.template.Template.modules.repository;


import com.example.template.Template.modules.data.UsersBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<UsersBook, Integer> {
    public List<UsersBook> getData(HashMap<String, Object> conditions);
    public List<UsersBook> findAllByUserId(Integer userId);
}
