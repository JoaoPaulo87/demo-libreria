package com.example.template.Template.app.repository;

import com.example.template.Template.app.data.UsersDTO;
import com.example.template.Template.modules.data.UsersBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersDTO, Long> {

    public abstract Optional<UsersDTO> findByUsername(String username);

    public abstract boolean existsByUsername(String username);
    public abstract List<UsersDTO> findAllByOrderByIdAsc();

}
