package com.michaelcgood.dao;

import com.michaelcgood.model.MenModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenRepository extends JpaRepository<MenModel,Long> {
}
