package com.wileyedge.elomatch.util;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.model.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    @Test
    @DisplayName("mapUserEntityToModel")
    public void testMapUserEntityToModel() {
        User user = new User();
        user.setUserName("barn22");
        user.setPlayerName("Barney");


        UserModel userModel = Mapper.mapUserEntityToModel(user);

        assertEquals(user.getUserName(), userModel.getUserName());
        assertEquals(user.getPlayerName(), userModel.getPlayerName());
    }

}