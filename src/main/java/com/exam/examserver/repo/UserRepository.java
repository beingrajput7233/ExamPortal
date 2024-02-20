package com.exam.examserver.repo;

import com.exam.examserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    //this function caused error bcoz "username" should be written as same as in "User Entity"----strictly case sensitive
    public User findByUsername(String username);

//    public User findByUserName(String username);
}
