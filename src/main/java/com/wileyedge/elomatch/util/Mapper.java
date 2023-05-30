package com.wileyedge.elomatch.util;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.model.CreateOrModifyUserModel;
import com.wileyedge.elomatch.model.UserModel;
import org.modelmapper.ModelMapper;

public class Mapper {

    // placing all static mapper methods in this class.
    private static final ModelMapper modelMapper = new ModelMapper();

//    public static User mapCreateOrModifyUserToUserEntity(CreateOrModifyUser createOrModifyUser){
//        User user = new User();
//        user.setPlayerName(createOrModifyUser.getPlayerName());
//        user.setUserName(createOrModifyUser.getUserName());
//        user.setElo(createOrModifyUser.getElo());
//        user.setIsToxic(createOrModifyUser.getIsToxic());
//        return user;
//    }

    public static User mapUserEntityToModel(CreateOrModifyUserModel model){
        return modelMapper.map(model, User.class);
    }


    public static UserModel mapUserEntityToModel(User user){
        return modelMapper.map(user, UserModel.class);
    }

    private Mapper(){

    }

}
