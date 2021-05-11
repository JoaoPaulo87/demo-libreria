package com.example.template.Template.modules.controller;

import com.example.template.Template.app.config.swagger.ControllerDocumentation;
import com.example.template.Template.app.data.UsersDTO;
import com.example.template.Template.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerDocumentation
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> findyById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(this.userService.findById(id));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UsersDTO> findyById(@PathVariable(name="username") String username){
        return ResponseEntity.ok(this.userService.findByUsername(username));
    }
}
