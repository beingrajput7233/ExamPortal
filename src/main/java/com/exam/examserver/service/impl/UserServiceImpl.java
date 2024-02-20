package com.exam.examserver.service.impl;

import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.repo.RoleRepository;
import com.exam.examserver.repo.UserRepository;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository, RoleRepository theRoleRepository) {
        userRepository = theUserRepository;
        roleRepository = theRoleRepository;
    }

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
      User local=this.userRepository.findByUsername(user.getUsername());
      if(local!=null){
          System.out.println("User is already present");
          throw new Exception("User already present!");
      }
      else{
            //user create
          for(UserRole ur:userRoles){
              //adding roles to db
              roleRepository.save(ur.getRole());
          }
            //setting roles of user
          user.getUserRoles().addAll(userRoles);
          local=this.userRepository.save(user);
      }
      return user;
    }
}
