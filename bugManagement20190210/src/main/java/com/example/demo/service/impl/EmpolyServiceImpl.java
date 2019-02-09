package com.example.demo.service.impl;

import com.example.demo.bean.Empoly;
import com.example.demo.jdbc.EmpolyMapper;
import com.example.demo.service.EmpolyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpolyServiceImpl implements EmpolyService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Empoly> findTester() {
        String sql = "SELECT EMPLOY_ID,EMPLOY_NAME FROM QA_EMPLOY where EMPLOY_GROUP = 1 and EMPLOY_DELETED_FLAG=0";
        List<Empoly> tester= jdbcTemplate.query(sql,new EmpolyMapper() );
        return tester;
    }

    @Override
    public List<Empoly> findDeveloper() {
        String sql = "SELECT EMPLOY_ID,EMPLOY_NAME FROM QA_EMPLOY where EMPLOY_GROUP = 2 and EMPLOY_DELETED_FLAG=0";
        List<Empoly> developer= jdbcTemplate.query(sql,new EmpolyMapper() );
        return developer;
    }


}
