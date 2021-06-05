package com.example.demo.controller;


import com.example.demo.dao.BookDao;
import com.example.demo.repo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/Book")
public class BookController {
    @Autowired
    private BookDao b;
    @GetMapping("findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1, size);
        return b.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = b.save(book);
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return b.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = b.save(book);
        if(result != null){
            return "success";
        }
        else{
            return "error";
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        b.deleteById(id);
    }
}
