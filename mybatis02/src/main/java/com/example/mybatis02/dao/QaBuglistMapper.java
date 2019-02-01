package com.example.mybatis02.dao;



import com.example.mybatis02.model.QaBuglist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QaBuglistMapper {


    int deleteByPrimaryKey(Integer bugId);


    int insert(QaBuglist record);

    QaBuglist selectByPrimaryKey(Integer bugId);

    List<QaBuglist> selectAll();

    int updateByPrimaryKey(QaBuglist record);
}