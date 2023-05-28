package com.wileyedge.elomatch.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // generate constructors without any arguments
@AllArgsConstructor // generate constructors with all arguments, respectively.
@Entity
@Table(name = "experience")
public class Experience {

    @Id // specifies the primary key column in the database table.
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "exp") // used to map the attributes to specific columns in the table.
    private String exp;

    //  establishes a one-to-many relationship with the User entity,
    //  specifying that one experience can be associated with multiple users.
    @OneToMany(mappedBy = "experience", cascade = CascadeType.ALL)
    private List<User> users;


}
