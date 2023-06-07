package com.wileyedge.elomatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {


    private Long id;

    private String playerName;

    private String userName;

    private Long elo;

    private Boolean isToxic;

}
