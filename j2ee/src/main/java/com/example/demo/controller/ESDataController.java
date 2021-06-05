package com.example.demo.controller;

import com.example.demo.dao.ESDataDao;
import com.example.demo.repo.ESData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/ESData")
public class ESDataController {
    @Autowired
    private ESDataDao d;
    @GetMapping("findAll/{page}/{size}")
    public Page<ESData> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return d.findAll(pageable);
    }
}
