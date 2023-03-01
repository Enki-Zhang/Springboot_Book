package com.enki.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.enki.pojo.Book;
import org.springframework.stereotype.Service;

/**
 * @author Enki
 * @Version 1.0
 */
public interface BookService extends IService<Book> {
    boolean deletByBookId(Integer id);
    IPage<Book> getPage(Integer page,Integer pageSize,Book book);
}
