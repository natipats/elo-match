package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.exception.ELOMaximumException;
import com.wileyedge.elomatch.exception.PlayerNameException;
import com.wileyedge.elomatch.exception.ToxicDataTypeException;
import com.wileyedge.elomatch.model.CreateUserModel;
import com.wileyedge.elomatch.model.ModifyUserModel;
import com.wileyedge.elomatch.model.UserModel;
import com.wileyedge.elomatch.persistence.UserRepository;
import com.wileyedge.elomatch.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public User saveUser(User user){
        return userRepository.save(user);

    }

    // why not saveAllUsers????
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }
// find
    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }


    public BigDecimal checkEloByLength(BigDecimal elo) throws ELOMaximumException {
        // Check if the ELO value is greater than 3000
       if(elo.compareTo(new BigDecimal("3000")) > 0){
           // Throw an ELOMaximumException with an error message
           throw new ELOMaximumException(
                   "ERROR: NO NO NO elo is not more than 3000"
           );
       }
        // If the ELO value is within the valid range, return the ELO value.
       return elo;
    }

    public String checkPlayerName(String playerName) throws PlayerNameException {

        // Check if the playerName contains a number
        if (containsNumber(playerName)) {
            // Throw a PlayerNameException with an error message
            throw new PlayerNameException("ERROR: Im a teapot. playerName cant contain a number");
        }

        // If the playerName is a valid string, return the unmodified value.
        return playerName;
    }

    public UserModel addNewUser(CreateUserModel model){
        // you need to from create new model, make an entity
        // before to make returning model save the entity
        // then to return user model you need to make from entity a model
        User currentUser = new User();
        currentUser.setUserName(model.getUserName());
        currentUser.setPlayerName(model.getPlayerName());

        return Mapper.mapUserEntityToModel(userRepository.save(currentUser));
    }

    //this one below may not be needed we can just call the one
   /* public String checkUserName(String userName) throws PlayerNameException{

        // Check if the userName contains a number
        if (containsNumber(userName)) {
            // Throw a PlayerNameException with an error message
            throw new PlayerNameException("ERROR: Im a teapot. userName cant contain a number");
        }

        // If the userName is a valid string, return the unmodified value.
        return userName;
    }*/

    private boolean containsNumber(String str) {
        // Iterate over each character in the string
        for (char c : str.toCharArray()) {
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                // Return true if a digit is found
                return true;
            }
        }

        // Return false if no digits are found
        return false;
    }

    public boolean checkIsToxic(boolean isToxic) throws ToxicDataTypeException {
        // Check if isToxic is a boolean
        if (!isToxic) {
            // Throw a ToxicDataTypeException with an error message
            throw new ToxicDataTypeException("ERROR: isToxic must be a boolean value");
        }

        // If isToxic is a valid boolean value, return the unmodified value.
        return isToxic;
    }


    public User findUserByName(String userName){
        return userRepository.findByUserName(userName);
    }
   // try to keep delete as void or if you want to keep back anything then keep as boolean

    public void deleteUser(Long id) {
        User currentUser = userRepository.findUsersById(id);
        if (currentUser == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }

    public UserModel updateUser(Long id, ModifyUserModel modifyUserModel) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            // Handle the case when the user with the given id is not found
            return null; // Or throw an exception, or handle it as per your requirement
        }

        try {
            existingUser.setUserName(modifyUserModel.getUserName());
            existingUser.setPlayerName(checkPlayerName(modifyUserModel.getPlayerName()));
            existingUser.setElo((long) Math.toIntExact(modifyUserModel.getElo()));
            existingUser.setIsToxic(checkIsToxic(modifyUserModel.getIsToxic()));
        } catch (PlayerNameException | /*ELOMaximumException | we cant get this to work*/ ToxicDataTypeException ex) {
            // Handle the specific exceptions and take appropriate actions
            // You can log the exception, throw a different exception, or handle it as per your requirement
            ex.printStackTrace();
            return null; // Or throw an exception, or handle it as per your requirement
        }

        return Mapper.mapUserEntityToModel(userRepository.save(existingUser));
    }
}
