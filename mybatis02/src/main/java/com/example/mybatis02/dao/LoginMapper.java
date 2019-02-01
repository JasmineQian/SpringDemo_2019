package com.example.mybatis02.dao;

import com.example.mybatis02.bean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("SELECT * FROM qa_buglist WHERE id = #{id}")
    UserBean getById(@Param("id") int id);

    /**通过搜索名字选择登录*/
    @Select("SELECT * FROM qa_buglist WHERE account = #{account}")
    UserBean getByName(@Param("account") String account);

    /**注册账号*/
    @Insert("INSERT INTO LOGIN(account,password) VALUES(#{account},#{password})")
    int register(UserBean userBean);

}
