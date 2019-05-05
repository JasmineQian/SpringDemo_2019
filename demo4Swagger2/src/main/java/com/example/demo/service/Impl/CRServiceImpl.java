package com.example.demo.service.Impl;

import com.example.demo.entity.CR;
import com.example.demo.jdbc.CRMapper;
import com.example.demo.service.CRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRServiceImpl implements CRService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<CR> findCRType() {
        String sql = "SELECT CR_ID,CR_NAME FROM QA_CRTYPE where CR_DELETED_FLAG = 0";
        List<CR> crtype= jdbcTemplate.query(sql,new CRMapper() );
        return crtype;
    }
}
