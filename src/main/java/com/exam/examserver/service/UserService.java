package com.exam.examserver.service;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username

    public User getUser(String username);

    //delete by User id
    public void deleteUser(Long userId);

}
