package com.example.mybaitis.dao;


import com.example.mybaitis.model.QaBuglist;

import java.util.List;


public interface QaBuglistMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer bugId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    int insert(QaBuglist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    QaBuglist selectByPrimaryKey(Integer bugId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    List<QaBuglist> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qa_buglist
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(QaBuglist record);
}