package com.example.demo.service.Impl;

import com.example.demo.entity.Case;
import com.example.demo.jdbc.CaseRowMapper;
import com.example.demo.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Case> findCasesbyTaskid(int id, int pageon) {

        int start = (pageon - 1) * 20;

        String sql= "SELECT CASE_ID,CASE_TASKID,TASK_NAME,CASE_NUM,CASE_PIRORITY,CASE_NAME,CASE_PRECONDITION,CASE_BODY,\n" +
                "CASE_ASSERTION,CASE_PASSFLAG,CASE_MEMO,CASE_CREATIONDT,CASE_UPDATEDT FROM QA_CASE\n" +
                "JOIN QA_TASK ON TASK_ID = CASE_TASKID\n" +
                "WHERE CASE_DELETED_FLAG =0 AND TASK_DELETED_FLAG = 0\n" +
                "AND CASE_TASKID = ? ";

        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Case> lists= jdbcTemplate.query(sql2,new CaseRowMapper(),id);
        return lists;
    }

    @Override
    public int countCasesbyTaskid(int id,int pageon) {

        String sql= "SELECT CASE_ID,CASE_TASKID,TASK_NAME,CASE_NUM,CASE_PIRORITY,CASE_NAME,CASE_PRECONDITION,CASE_BODY,\n" +
                "CASE_ASSERTION,CASE_PASSFLAG,CASE_MEMO,CASE_CREATIONDT,CASE_UPDATEDT FROM QA_CASE\n" +
                "JOIN QA_TASK ON TASK_ID = CASE_TASKID\n" +
                "WHERE CASE_DELETED_FLAG =0 AND TASK_DELETED_FLAG = 0\n" +
                "AND CASE_TASKID = ? ";

        int count = jdbcTemplate.query(sql, new CaseRowMapper(), id).size();

        return count;
    }



    @Override
    public Case findById(int id) {

        String sql = "select CASE_ID,CASE_TASKID,TASK_NAME,CASE_NUM,CASE_PIRORITY,CASE_NAME,CASE_PRECONDITION,CASE_BODY,\n" +
                "CASE_ASSERTION,CASE_PASSFLAG,CASE_MEMO,CASE_CREATIONDT,CASE_UPDATEDT\n" +
                "from qa_case\n" +
                "join qa_task on TASK_ID = CASE_TASKID\n" +
                "where CASE_DELETED_FLAG =0 and TASK_DELETED_FLAG = 0\n" +
                "and CASE_ID = ? ";
        Case testcase = jdbcTemplate.queryForObject(sql, new CaseRowMapper(), id);
        return testcase;
    }

    @Override
    public int create(Case testcase) {

        String sql ="insert qa_case(CASE_TASKID,CASE_NUM,CASE_PIRORITY,CASE_NAME,CASE_PRECONDITION,CASE_BODY,CASE_ASSERTION,CASE_PASSFLAG,CASE_CREATIONDT,CASE_UPDATEDT)\n" +
                "values(?,?,?,?,?,?,?,?,?,?) ";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);


        int taskid = testcase.getCase_taskid();
        int CASE_NUM =testcase.getCase_num();
        int CASE_PIRORITY =testcase.getCase_pirority();
        String CASE_NAME =testcase.getCase_name();
        String CASE_PRECONDITION =testcase.getCase_precondition();
        String CASE_BODY =testcase.getCase_body();
        String CASE_ASSERTION =testcase.getCase_assertion();
        int CASE_PASSFLAG =testcase.getCase_pass_flag();

        int count = jdbcTemplate.update(sql,taskid, CASE_NUM, CASE_PIRORITY, CASE_NAME, CASE_PRECONDITION, CASE_BODY, CASE_ASSERTION, CASE_PASSFLAG, date, date);
        System.out.println(count);
        return count;
    }

    @Override
    public int createList(List<Case> list) {
        return 0;
    }

    @Override
    public int update(Case testcase) {

        String sql = "update qa_case set  CASE_NUM = ?,CASE_PIRORITY = ?, CASE_NAME = ?, CASE_PRECONDITION = ?,\n" +
                "CASE_BODY = ?, CASE_ASSERTION = ?, CASE_PASSFLAG = ?, CASE_UPDATEDT= ? where CASE_ID= ?";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int id = testcase.getCase_id();
        int CASE_NUM =testcase.getCase_num();
        int CASE_PIRORITY =testcase.getCase_pirority();
        String CASE_NAME =testcase.getCase_name();
        String CASE_PRECONDITION =testcase.getCase_precondition();
        String CASE_BODY =testcase.getCase_body();
        String CASE_ASSERTION =testcase.getCase_assertion();
        int CASE_PASSFLAG =testcase.getCase_pass_flag();

        int count = jdbcTemplate.update(sql, CASE_NUM, CASE_PIRORITY, CASE_NAME, CASE_PRECONDITION, CASE_BODY, CASE_ASSERTION, CASE_PASSFLAG, date, id);
        return count;
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update qa_case set  CASE_DELETED_FLAG =1, CASE_DELETED_COMMENT = '页面逻辑删除', CASE_UPDATEDT= ? where CASE_ID= ?";
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
