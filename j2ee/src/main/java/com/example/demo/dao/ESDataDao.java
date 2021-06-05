package com.example.demo.dao;

import com.example.demo.repo.ESData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ESDataDao extends JpaRepository<ESData, Integer> {

}
