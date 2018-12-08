package com.michaelcgood.dao;

import com.michaelcgood.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {
    @Query("SELECT username FROM Login l where l.username = :username AND l.password = :password")
    public String findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
