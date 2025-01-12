package com.jwt.auth.jwt_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.auth.jwt_auth.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User>findByEmail(String email);

}
