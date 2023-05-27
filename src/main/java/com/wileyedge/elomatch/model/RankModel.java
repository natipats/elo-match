package com.wileyedge.elomatch.model;

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
public class RankModel {

    @Id
    @Column(name = "ranking_id", nullable = false)
    private Integer ranking_id;
    @Column(name = "exp")
    private String exp;

    @OneToMany(mappedBy = "ranking", cascade = CascadeType.ALL)
    private List<UserModel> userid;


}
