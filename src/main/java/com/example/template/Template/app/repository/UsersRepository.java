package com.example.template.Template.app.repository;

import com.example.template.Template.app.data.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersDTO, Long> {

    public abstract Optional<UsersDTO> findByUsername(String username);

    public abstract boolean existsByUsername(String username);

}
