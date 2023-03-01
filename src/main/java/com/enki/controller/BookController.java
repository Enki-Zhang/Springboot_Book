package com.enki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.enki.controller.utils.R;
import com.enki.pojo.Book;
import com.enki.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Enki
 * @Version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
//    查询所有
    @GetMapping("/list")
    public R getBookList(){
//        LambdaQueryWrapper<Book> LQW = new LambdaQueryWrapper<>();
//        LambdaQueryWrapper<Book> eq = LQW.like(Book::getName, book.getName()).eq(Book::getType, book.getType()).eq(Book::getDescription, book.getDescription());



        return new R(true,bookService.list());
    }


    @PostMapping()
    public R insertBook(@RequestBody Book book){
      return new R(bookService.save(book));
    }

    @PutMapping()
    public R update(@RequestBody Book book){
       return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delet(@PathVariable Integer id){
        return new R(bookService.deletByBookId(id));

    }

    @GetMapping("/{id}")
    public R getBookById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping("/page/{page}/{pageSize}")
    public R getPage(@PathVariable Integer page, @PathVariable Integer pageSize,Book book){
//        System.out.println(book);

        IPage<Book> page1 = bookService.getPage(page, pageSize,book);
        if (page>page1.getPages()){
            page1 =  bookService.getPage((int) page1.getPages(), pageSize,book);
        }
        return new R(true,page1);
    }








}
