package io.sudhakar.student.service;

import io.sudhakar.student.dto.ServiceResponse;
import io.sudhakar.student.dto.User;
import io.sudhakar.student.dto.UserDetails;

import java.util.List;

public interface UserService {

    ServiceResponse<List<UserDetails>> getAllUser();

    ServiceResponse<UserDetails> getUser(int id);

    ServiceResponse<Void> addUser(UserDetails userDetails);

    ServiceResponse<Void> updateUser(UserDetails userDetails,int id);

    ServiceResponse<Void> deleteUser(int id);



//    ServiceResponse<Void> addUser(User task);
//
//    ServiceResponse<Void> updateUser(int id, User user);
//
//    ServiceResponse<Void> deleteUser(int id);
//
//    ServiceResponse<Void> addManyUser(List<User> users);
//
//    ServiceResponse<Void> updateManyUser(List<User> users);

//    ServiceResponse<Void> deleteManyUser(List<User> ids);

}

