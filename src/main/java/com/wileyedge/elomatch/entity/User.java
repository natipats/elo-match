package com.wileyedge.elomatch.entity;

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
// Add a no-argument constructor
// This annotation generates a constructor with no arguments for the class.
// It allows creating instances of the class without providing any initial values for its fields.
@NoArgsConstructor
// Add a constructor with arguments for all fields
// This annotation generates a constructor that accepts arguments for all fields in the class.
// It simplifies the process of initialising objects by automatically creating a constructor
// that sets values for all fields.
@AllArgsConstructor
public class User {

    // This will represent the entity in the database.

    @Id // specifies the primary key column in the database table.
     //sequence will increase by 1 as default value.
     //So it'll start at 1 counting up to 2, 3, 4, 5, 6, 7, 8, 9, 10 etc
    @SequenceGenerator(   //  defines a sequence generator for the primary key values.
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
     //the generated value will be a sequence.
     //SEQUENCE, indicating that the primary key values for the annotated entity
     //will be generated using a database sequence.
    @GeneratedValue( // specifies the strategy for generating primary key values, using the sequence generator defined.
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "player_name", nullable = false, columnDefinition = "TEXT")
    private String playerName;
    @Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
    private String userName;
    @Column(name = "elo")
    private Long elo;
    @Column(name = "is_toxic", columnDefinition = "BIT(1)")
    private Boolean isToxic;

    // We have included a ManyToOne relationship with the Experience entity,
    // specifying that multiple users can be associated with a single experience.
    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    public User(String playerName, String userName, Long elo, Boolean isToxic) {
        this.playerName = playerName;
        this.userName = userName;
        this.elo = elo;
        this.isToxic = isToxic;

    }
}
