package com.enki.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.enki.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Enki
 * @Version 1.0
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {


}
