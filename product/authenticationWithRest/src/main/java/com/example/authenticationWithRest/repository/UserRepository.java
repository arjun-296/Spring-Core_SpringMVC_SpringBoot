package com.example.authenticationWithRest.repository;

import com.example.authenticationWithRest.exception.UserNotFoundException;
import com.example.authenticationWithRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public abstract User findByUserIdAndPassword(int userid, String password) throws UserNotFoundException;
}
