package com.lq.demo.mapper;

import com.lq.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemoMapper {

    @Select("SELECT * FROM user")
    List<User> grtAll();

}
