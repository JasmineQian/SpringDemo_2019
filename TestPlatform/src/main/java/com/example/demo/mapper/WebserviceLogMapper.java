package com.example.demo.mapper;

import com.example.demo.bean.po.WebserviceLog;
import com.example.demo.bean.po.WebserviceLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebserviceLogMapper {

    int countByExample(WebserviceLogExample example);

    int deleteByExample(WebserviceLogExample example);

    int deleteByPrimaryKey(String wlgId);

    int insert(WebserviceLog record);

    int insertSelective(WebserviceLog record);

    List<WebserviceLog> selectByExampleWithBLOBs(WebserviceLogExample example);

    List<WebserviceLog> selectByExample(WebserviceLogExample example);

    WebserviceLog selectByPrimaryKey(String wlgId);

    int updateByExampleSelective(@Param("record") WebserviceLog record, @Param("example") WebserviceLogExample example);

    int updateByExampleWithBLOBs(@Param("record") WebserviceLog record, @Param("example") WebserviceLogExample example);

    int updateByExample(@Param("record") WebserviceLog record, @Param("example") WebserviceLogExample example);

    int updateByPrimaryKeySelective(WebserviceLog record);

    int updateByPrimaryKeyWithBLOBs(WebserviceLog record);

    int updateByPrimaryKey(WebserviceLog record);

}
