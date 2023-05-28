package com.wileyedge.elomatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "exp")
    private String exp;


    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL)
    private List<User> users;


}
