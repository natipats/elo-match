package com.wileyedge.elomatch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModifyUserModel {

    // you only need the playerName and UserName to modify the user
    // you wouldn't allow the user to change rank or change the istoxic player otherwise
    // they could cheat.
    // they can also create their own user identity to start a match
    // which will identify them as beginner status.
    private String playerName;
    private String userName;
    // For now, I have added elo and isToxic for insert data.
    private Long elo;
    private Boolean isToxic;

}

