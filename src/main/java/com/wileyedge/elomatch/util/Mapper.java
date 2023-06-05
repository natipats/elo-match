package com.wileyedge.elomatch.util;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.model.ModifyUserModel;
import com.wileyedge.elomatch.model.UserModel;
import org.modelmapper.ModelMapper;

public class Mapper {

    // placing all static mapper methods in this class.
    // Create a ModelMapper object for mapping entities to models.
    private static final ModelMapper modelMapper = new ModelMapper();


    // Setting the User object properties based on the CreateOrModifyUserModel properties.
    // This was my first interpretation of the mapper created before.
    // It creates a new object.
    // Then Returns the User entity object.

//    public static User mapCreateOrModifyUserToUserEntity(CreateOrModifyUser createOrModifyUser){
//        User user = new User();
//        user.setPlayerName(createOrModifyUser.getPlayerName());
//        user.setUserName(createOrModifyUser.getUserName());
//        user.setElo(createOrModifyUser.getElo());
//        user.setIsToxic(createOrModifyUser.getIsToxic());
//        return user;
//    }

    // Map a CreateOrModifyUserModel object to a User entity.
    // Create a new User object.
    public static User mapModifyUserModelToEntity(ModifyUserModel model){
        return modelMapper.map(model, User.class);
    }

    // Map a User entity to a UserModel object.
    // Use the modelMapper object to map the properties from User to UserModel
    public static UserModel mapUserEntityToModel(User user){
        return modelMapper.map(user, UserModel.class);
    }

    // Private constructor to prevent instantiation of the Mapper class
    private Mapper(){
        // This constructor is empty as it's meant to prevent the instantiation of the Mapper class.
    }

}
