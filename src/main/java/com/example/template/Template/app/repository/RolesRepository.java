package com.example.template.Template.app.repository;

import com.example.template.Template.app.data.ERoleEnum;
import com.example.template.Template.app.data.RolesDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<RolesDTO, Integer> {

    public abstract Optional<RolesDTO> findByName(ERoleEnum name);

}
