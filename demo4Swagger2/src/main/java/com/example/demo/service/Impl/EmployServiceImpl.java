package com.example.demo.service.Impl;

import com.example.demo.entity.Employ;
import com.example.demo.jdbc.EmpolyMapper;
import com.example.demo.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployServiceImpl implements EmployService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employ> findTester() {
        String sql = "SELECT EMPLOY_ID,EMPLOY_NAME FROM QA_EMPLOY where EMPLOY_GROUP = 1 and EMPLOY_DELETED_FLAG=0";
        List<Employ> tester= jdbcTemplate.query(sql,new EmpolyMapper() );
        return tester;
    }

    @Override
    public List<Employ> findDeveloper() {
        String sql = "SELECT EMPLOY_ID,EMPLOY_NAME FROM QA_EMPLOY where EMPLOY_GROUP = 2 and EMPLOY_DELETED_FLAG=0";
        List<Employ> developer= jdbcTemplate.query(sql,new EmpolyMapper() );
        return developer;
    }


}
