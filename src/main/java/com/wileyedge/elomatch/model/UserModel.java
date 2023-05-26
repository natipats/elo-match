package com.wileyedge.elomatch.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserModel {

    private int elo;
    private int userID;
    private String playerName;
    private String userName;
    private boolean isToxic;

}
