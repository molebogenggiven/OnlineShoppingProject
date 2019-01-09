package com.michaelcgood.dao;

import com.michaelcgood.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin,String> {
    @Query("SELECT username FROM UserLogin l where l.username = :username AND l.password = :password")
    String findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
