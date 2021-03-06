package com.example.template.Template.modules.controller;

import com.example.template.Template.app.config.swagger.ControllerDocumentation;
import com.example.template.Template.app.data.UsersDTO;
import com.example.template.Template.modules.data.UsersBook;
import com.example.template.Template.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@ControllerDocumentation
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/id/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsersDTO> findyById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping("/name/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsersDTO> findyByName(@PathVariable(name="username") String username){
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<UsersDTO>> findAllByOrderByIdAsc(){
        return ResponseEntity.ok(this.userService.findAllByOrderByIdAsc());
    }
}
