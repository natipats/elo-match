package com.wileyedge.elomatch.service;

import com.wileyedge.elomatch.entity.User;
import com.wileyedge.elomatch.model.CreateUserModel;
import com.wileyedge.elomatch.model.ModifyUserModel;
import com.wileyedge.elomatch.model.UserModel;
import com.wileyedge.elomatch.persistence.UserRepository;
import com.wileyedge.elomatch.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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


//    public BigDecimal checkEloByLength(BigDecimal elo) throws ELOMaximumException {
//       if(elo.compareTo(new BigDecimal("2000")) > 3000){
//           throw new ELOMaximumException(
//                   "ERROR: NO NO NO elo is not more than 3000"
//           );
//       }
//       return elo;
//    }


    public UserModel addNewUser(CreateUserModel model){
        // you need to from create new model, make an entity
        // before to make returning model save the entity
        // then to return user model you need to make from entity a model
        User currentUser = new User();
        currentUser.setUserName(model.getUserName());
        currentUser.setPlayerName(model.getPlayerName());

        return Mapper.mapUserEntityToModel(userRepository.save(currentUser));
    }





    public User findUserByName(String userName){
        return userRepository.findByUserName(userName);
    }
   // try to keep delete as void or if you want to keep back anything then keep as boolean

    public String deleteUser(Long id){
       userRepository.deleteById(id);
       return "User removed " + id;
    }

    public UserModel updateUser(Long id, ModifyUserModel modifyUserModel) {
        // existing user id which comes from the database from particular id search
        // and then that will be the existing whole user. with all fields, and original.
        User existingUser = userRepository.findById(id).orElse(null);
        // .1 found
        // .2 set modification fields inside
        Objects.requireNonNull(existingUser).setUserName(modifyUserModel.getUserName());
        existingUser.setPlayerName(modifyUserModel.getPlayerName());
        existingUser.setElo((long) Math.toIntExact(modifyUserModel.getElo()));
        existingUser.setIsToxic(modifyUserModel.getIsToxic());
//        existingUser.setUserName(user.getUserName());
//        existingUser.setPlayerName(user.getPlayerName());
//        existingUser.setElo(user.getElo());
        // existingUser. need to figure out isToxic, not appearing as get method.
        return Mapper.mapUserEntityToModel(userRepository.save(existingUser));
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
