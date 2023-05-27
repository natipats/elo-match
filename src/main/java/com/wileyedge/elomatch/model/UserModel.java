package com.wileyedge.elomatch.model;

import com.wileyedge.elomatch.persistence.UserRepository;
import com.wileyedge.elomatch.service.UserServiceImpl;
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
    // SEQUENCE, indicating that the primary key values for the annotated entity
    // will be generated using a database sequence.
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "user_id", nullable = false)
    private Integer userid;
    @Column(name = "player_name", nullable = false, columnDefinition = "TEXT")
    private String playerName;
    @Column(name = "user_name", nullable = false, columnDefinition = "TEXT")
    private String userName;
    @Column(name = "elo")
    private long elo;
    @Column(name = "is_toxic", columnDefinition = "BIT(1)")
    private boolean isToxic;

    @ManyToOne
    @JoinColumn(name = "ranking_id")
    private RankModel ranking;

    public UserModel(String playerName, String userName, long elo, boolean isToxic) {
        this.playerName = playerName;
        this.userName = userName;
        this.elo = elo;
        this.isToxic = isToxic;
    }
}
