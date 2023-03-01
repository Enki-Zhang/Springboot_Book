package com.enki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.enki.dao.BookDao;
import com.enki.pojo.Book;
import com.enki.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.nio.IntBuffer;

/**
 * @author Enki
 * @Version 1.0
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean deletByBookId(Integer id) {
        int i = bookDao.deleteById(id);
        if (i == 0) {
            return false;
        }
        return true;
    }

    @Override
    public IPage<Book> getPage(Integer page, Integer pageSize, Book book) {
//        条件查询
        LambdaQueryWrapper<Book> LQW = new LambdaQueryWrapper<>();

//        if (book.getName() != null) {
//            LQW.eq(Book::getName, book.getName());
//        }
//        if (book.getType() != null) {
//            LQW.eq(Book::getType, book.getType());
//        }
//        if (book.getDescription() != null) {
//            LQW.eq(Book::getDescription, book.getDescription());
//        }

        LQW.like(!Strings.isEmpty(book.getName()),Book::getName,book.getName());
        LQW.like(!Strings.isEmpty(book.getType()),Book::getType,book.getType());
        LQW.like(!Strings.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        Page<Book> bookPage = new Page<>(page, pageSize);
        return bookDao.selectPage(bookPage, LQW);


    }
}
