package com.michaelcgood.dao;

import com.michaelcgood.model.Customer;
import com.michaelcgood.model.TemporaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface TemporaryRepository extends JpaRepository<TemporaryModel, String> {

    @Query("SELECT username, firstName, lastName, password, " +
            " passwordVerify, phoneNumber, gender, title  " +
            " FROM TemporaryModel t where t.code = :code")
    TemporaryModel getAllCustomerDetails(@Param("code") long code);

    @Query("SELECT username FROM TemporaryModel l where l.username = :username AND l.code = :code")
    public String verifyUsernameAndCode(@Param("username") String username, @Param("code") int code);

    @Query("SELECT username FROM TemporaryModel l where l.username = :username")
    public String verifyUsername(@Param("username") String username);

    @Query("SELECT l FROM TemporaryModel l where l.username = :username")
    public TemporaryModel getCustomerDatails(@Param("username") String username);


    @Modifying
    @Query("Update TemporaryModel t SET t.status=:status WHERE t.username=:username")
    public void updateStatus(@Param("username") String username, @Param("status") String status);


}
