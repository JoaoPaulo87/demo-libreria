package com.example.template.Template.modules.service;

import com.example.template.Template.app.data.UsersDTO;
import com.example.template.Template.app.repository.UsersRepository;
import com.example.template.Template.modules.data.UsersBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public UsersDTO findById(Long id){
        return this.usersRepository.findById(id).orElse(null);
    }

    public UsersDTO findByUsername(String username){
        return this.usersRepository.findByUsername(username).orElse(null);
    }

    public List<UsersDTO> findAllByOrderByIdAsc(){
        return this.usersRepository.findAllByOrderByIdAsc();
    }
}
