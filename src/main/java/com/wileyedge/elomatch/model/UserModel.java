package com.wileyedge.elomatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    // This will represent the entity in the database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;
    @Column(name = "playerName")
    private String playerName;
    @Column(name = "userName")
    private String userName;
    @Column(name = "elo")
    private long elo;
    @Column(name = "isToxic")
    private boolean isToxic;

}
