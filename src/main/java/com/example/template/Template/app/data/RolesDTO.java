package com.example.template.Template.app.data;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class RolesDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoleEnum name;

    public RolesDTO() {
    }

    public RolesDTO(Integer id, ERoleEnum name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoleEnum getName() {
        return name;
    }

    public void setName(ERoleEnum name) {
        this.name = name;
    }
}
