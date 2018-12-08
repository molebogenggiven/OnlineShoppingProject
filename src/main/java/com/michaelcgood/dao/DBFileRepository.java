package com.michaelcgood.dao;

import com.michaelcgood.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
