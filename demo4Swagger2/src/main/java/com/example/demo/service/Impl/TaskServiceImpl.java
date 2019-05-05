package com.example.demo.service.Impl;

import com.example.demo.entity.Task;
import com.example.demo.jdbc.TaskRowMapper;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Task> findAll() {
        String sql = "SELECT TASK_ID,TASK_PID,PROJECT_NAME,TASK_TID, OBJECT_NAME,\n" +
                "TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,TASK_CREATIONDT,TASK_UPDATEDT\n" +
                "FROM QA_TASK \n" +
                "JOIN  QA_PROJECT ON TASK_PID =  PROJECT_ID\n" +
                "JOIN  QA_RTYPE ON OBJECT_ID = TASK_TID\n" +
                "WHERE  TASK_DELETED_FLAG = 0 order by 1 desc";
        List<Task> lists = jdbcTemplate.query(sql, new TaskRowMapper());
        return lists;
    }

    @Override
    public List<Task> findMultiByCondtion(int pageon, int pid, String name, String description) {

        int start = (pageon - 1) * 20;
        String sql = "SELECT TASK_ID,TASK_PID,PROJECT_NAME,TASK_TID, OBJECT_NAME,\n" +
                "TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,TASK_CREATIONDT,TASK_UPDATEDT\n" +
                "FROM QA_TASK \n" +
                "JOIN  QA_PROJECT ON TASK_PID =  PROJECT_ID\n" +
                "JOIN  QA_RTYPE ON OBJECT_ID = TASK_TID\n" +
                "WHERE  TASK_DELETED_FLAG = 0";

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


        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Task> lists = jdbcTemplate.query(sql2, queryList.toArray(), new TaskRowMapper());
        System.out.println(sql2);
        return lists;

    }

    @Override
    public int countAll(int pageon, int pid, String name, String description) {

        String sql = "SELECT TASK_ID,TASK_PID,PROJECT_NAME,TASK_TID, OBJECT_NAME,\n" +
                "TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,TASK_CREATIONDT,TASK_UPDATEDT\n" +
                "FROM QA_TASK \n" +
                "JOIN  QA_PROJECT ON TASK_PID =  PROJECT_ID\n" +
                "JOIN  QA_RTYPE ON OBJECT_ID = TASK_TID\n" +
                "WHERE  TASK_DELETED_FLAG = 0";

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

        int count = jdbcTemplate.query(sql, queryList.toArray(), new TaskRowMapper()).size();
        return count;
    }


    @Override
    public Task findById(int id) {
        String sql = "select TASK_ID,TASK_PID,PROJECT_NAME,TASK_TID, OBJECT_NAME,\n" +
                "TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,TASK_CREATIONDT,TASK_UPDATEDT\n" +
                "FROM qa_task \n" +
                "JOIN  QA_PROJECT ON TASK_PID =  PROJECT_ID\n" +
                "JOIN  qa_rtype ON OBJECT_ID = TASK_TID\n" +
                "WHERE  TASK_DELETED_FLAG = 0\n" +
                "and TASK_ID = ?";

        Task task = jdbcTemplate.queryForObject(sql, new TaskRowMapper(), id);
        return task;
    }

    @Override
    public int create(Task task) {
        String sql = "insert qa_task(TASK_PID,TASK_TID,TASK_NAME,TASK_CRNAME,TASK_DESCRIPTION,TASK_DETAILS,TASK_NOTE,TASK_CREATIONDT,TASK_UPDATEDT)\n" +
                "values(?,?,?,?,?,?,?,?,?)";
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int pid = task.getTask_pid();
        int tid = task.getTask_tid();
        String taskname = task.getTaskname();
        String taskcrname = task.getCrname();
        String desciprtion = task.getDescription();
        String Details = task.getDetails();
        String note = task.getNote();


        int count = jdbcTemplate.update(sql, pid, tid, taskname, taskcrname, desciprtion, Details, note, date, date);
        return count;
    }

    @Override
    public int update(Task task) {
        String sql = "update qa_task set TASK_NAME=? ,TASK_CRNAME =? ,TASK_DESCRIPTION =? ,TASK_DETAILS =? ,TASK_NOTE =? ,TASK_UPDATEDT =?\n" +
                "where TASK_ID = ?";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int id = task.getTaskid();
        String taskname = task.getTaskname();
        String taskcrname = task.getCrname();
        String desciprtion = task.getDescription();
        String Details = task.getDetails();
        String note = task.getNote();
        int count = jdbcTemplate.update(sql, taskname, taskcrname, desciprtion, Details, note, date, id);
        return count;
    }

    @Override
    public int deleteByID(int id) {
        String sql = "UPDATE QA_TASK SET TASK_DELETED_FLAG = 1, TASK_DELETED_COMMENT = '逻辑删除', TASK_UPDATEDT = ? WHERE TASK_ID= ?";
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
