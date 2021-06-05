package com.example.demo.repo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class ESData {
    @Id
    private Integer id;
    private String name;
    private String author;
}
