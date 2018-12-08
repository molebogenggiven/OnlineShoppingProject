package com.michaelcgood.dao;


import com.michaelcgood.model.PictureModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<PictureModel,Long> {
}
