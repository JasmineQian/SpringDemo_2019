package com.example.demo.service.Impl;


import com.example.demo.entity.CaseReport;
import com.example.demo.jdbc.CaseReportRowMapper;
import com.example.demo.service.CaseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseReportServiceImpl implements CaseReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<CaseReport> findByCondtion(int pid, String name, String description) {
        String sql = "SELECT TASK_ID,PROJECT_NAME,OBJECT_NAME,TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,\n" +
                "CASE_ID,CASE_TASKID,CASE_NUM,PIRORITY_NAME,CASE_NAME,CASE_PRECONDITION,CASE_BODY,CASE_ASSERTION,CASEPASSFLAG_NAME,CASE_MEMO,CASE_CREATIONDT,CASE_UPDATEDT\n" +
                "FROM QA_TASK JOIN QA_CASE ON TASK_ID = CASE_TASKID\n" +
                "JOIN QA_PROJECT ON TASK_PID = PROJECT_ID\n" +
                "JOIN QA_RTYPE ON OBJECT_ID = TASK_TID\n" +
                "JOIN QA_PIRORITY ON PIRORITY_ID = CASE_PIRORITY\n" +
                "JOIN QA_CASEPASSFLAG ON CASEPASSFLAG_ID = CASE_PASSFLAG\n" +
                "WHERE TASK_DELETED_FLAG =0";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and TASK_PID = ? ";
            queryList.add(pid);
        }
        if (name!=null) {
            sql += " and TASK_CRNAME like ? ";
            queryList.add("%" + name.trim() + "%");
        }
        if (description!=null) {
            sql += " and TASK_DESCRIPTION  like ? ";
            queryList.add("%" + description.trim() + "%");
        }


        List<CaseReport> lists = jdbcTemplate.query(sql, queryList.toArray(), new CaseReportRowMapper());
        return lists;
    }
}
