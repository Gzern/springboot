package com.example.demo.mapper;

import com.example.demo.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface PersonMapper {

//    @Select("select * from tb_person where id=#{id}")
    public Person findPersonById(Integer id);
}
