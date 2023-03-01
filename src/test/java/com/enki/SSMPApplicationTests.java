package com.enki;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.enki.dao.BookDao;
import com.enki.pojo.Book;
import com.enki.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SSMPApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
        ;
    }

    @Test
    public void testIpage() {
        Page<Book> bookPage = new Page<>(1, 5);
        Page<Book> bookPage1 = bookDao.selectPage(bookPage, null);
        System.out.println(bookPage1.getPages());
        System.out.println(bookPage1.getTotal());

        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Book> select = queryWrapper.select("id", "type");
        List<Object> objects = bookDao.selectObjs(select);
        objects.forEach(System.out::println);

        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.select();


    }

    @Test
    public void testSelectList() {
        bookDao.selectList(null).forEach(System.out::println);
    }

    @Test
    public void insertBook() {
        int insert = bookDao.insert(new Book(null, "经济", "八次危机：中国的真实经验1949-2009", "klkl"));
        if (insert != 0) {
            System.out.println("插入成功");
        }else{
            System.out.println("失败");

        }

    }

    @Test
    public void testSelectListMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("type","人间清醒");
        map.put("name","鲁迅全集");
        List<Book> books = bookDao.selectByMap(map);
        books.forEach(System.out::println);


    }


    @Test
    public void testService(){
        long count = bookService.count();
        System.out.println(count);
    }

    @Test
    public void testWQ(){
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        QueryWrapper<Book> like = queryWrapper.like("name", "八");
        List<Book> books = bookDao.selectList(like);
       books.forEach(System.out::println);

        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Book> book = bookLambdaQueryWrapper.like(Book::getName, "八");
        List<Book> books1 = bookDao.selectList(book);
        books1.forEach(System.out::println);

    }

    @Test
    public void testQWPage(){
        Book book = new Book();
        book.setName("八次危机：中国的真实经验1949-2009\n");
        IPage<Book> page = bookService.getPage(1, 2, book);
        System.out.println(page.getTotal());
    }



}
