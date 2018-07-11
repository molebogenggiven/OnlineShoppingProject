package com.michaelcgood.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.michaelcgood.model.Given;

@Repository
public interface SystemRepository extends JpaRepository<Given,Long> {
	

}
