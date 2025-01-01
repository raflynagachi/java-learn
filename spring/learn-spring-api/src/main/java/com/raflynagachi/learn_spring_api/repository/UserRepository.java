package com.raflynagachi.learn_spring_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raflynagachi.learn_spring_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
}
