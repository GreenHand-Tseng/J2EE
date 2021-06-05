package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ESDataDaoTest {
    @Autowired
    private ESDataDao b;
    @Test
    void findAll(){
        System.out.println(b.findAll());
    }
}