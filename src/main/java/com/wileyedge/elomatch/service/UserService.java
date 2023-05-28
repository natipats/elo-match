package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.model.ModifyUser;
import com.wileyedge.elomatch.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private final UserRepository userRepository;


    public User saveUser(User user){
        return userRepository.save(user);

    }

    // why not saveAllUsers????
    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String userName){
        return userRepository.findByUserName(userName);
    }
   // try to keep delete as void or if you want to keep back anything then keep as boolean
    public String deleteUser(Long id){
       userRepository.deleteById(id);
       return "User removed " + id;
    }

    public User updateUser(Long id, ModifyUser modifyUser) {
        // existing user id which comes from the database from particular id search
        // and then that will be the existing whole user. with all fields, and original.
        User existingUser = userRepository.findById(id).orElse(null);
        // .1 found
        // .2 set modification fields inside
        Objects.requireNonNull(existingUser).setUserName(modifyUser.getUserName());
        existingUser.setPlayerName(modifyUser.getPlayerName());
//        existingUser.setUserName(user.getUserName());
//        existingUser.setPlayerName(user.getPlayerName());
//        existingUser.setElo(user.getElo());
        // existingUser. need to figure out isToxic, not appearing as get method.
        return userRepository.save(existingUser);
    }

//    public UserModel updateUser(UserModel user) {
//        UserModel existingUser = userRepository.findById(user.getUser_id()).orElse(null);
//        existingUser.setUserName(user.getUserName());
//        existingUser.setPlayerName(user.getPlayerName());
//        existingUser.setElo(user.getElo());
//        existingUser.setToxic(user.isToxic());
//        // existingUser. need to figure out isToxic, not appearing as get method.
//        return userRepository.save(existingUser);
//    }



}
