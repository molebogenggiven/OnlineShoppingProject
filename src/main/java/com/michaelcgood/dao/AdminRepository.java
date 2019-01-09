package com.michaelcgood.dao;

import com.michaelcgood.model.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminLogin, String> {

    @Query("SELECT username FROM AdminLogin l where l.username = :username AND l.password = :password")
    String findAdminByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
