package com.wileyedge.elomatch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
// This means that it is now an identity
// and it is now mapped to a database.
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    // This will represent the entity in the database.

    @Id
    // sequence will increase by 1 as default value.
    // So it'll start at 1 counting up to 2, 3, 4, 5, 6, 7, 8, 9, 10 etc
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    // the generated value will be a sequence.
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
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
