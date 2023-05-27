package com.wileyedge.elomatch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Table;

@Getter
@Setter
@Entity
@Table(name="user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Column()
    private long elo;
    @Column(name="henry")
    private String playerName;
    private String userName;
    private boolean isToxic;

}
