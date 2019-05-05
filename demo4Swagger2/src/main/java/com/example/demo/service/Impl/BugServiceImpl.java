package com.example.demo.service.Impl;

import com.example.demo.entity.Bug;
import com.example.demo.jdbc.BugRowMapper;
import com.example.demo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Bug> findAllbyPage(int pageon, int pid, String crnum, String tasknum, int testerid, int devid) {


        int start =(pageon-1)*20;
        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0";
        List <Object> queryList=new ArrayList<Object>();
        if (pid!=0) { sql += " and BUG_PROJECT_ID = ? "; queryList.add(pid);}
        if (crnum!=null) { sql += " and bug_cr_num like ? "; queryList.add("%"+crnum.trim()+"%");}
        if (tasknum!=null) { sql += " and bug_task_num  like ? "; queryList.add("%"+tasknum.trim()+"%");}
        if (testerid!=0) { sql += " and qa_tester_id = ? ";queryList.add(testerid);}
        if (devid!=0) { sql += " and qa_assignee_id = ?  ";queryList.add(devid);}

        String sql2 =sql +" order by 1 desc limit "+ start +" , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Bug> lists =jdbcTemplate.query(sql2,queryList.toArray(),new BugRowMapper());
        return lists;
    }


    @Override
    public int countAll(int pid,String crnum,String tasknum, int testerid, int devid){

        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0";
        List <Object> queryList=new ArrayList<Object>();
        if (pid!=0) { sql += " and BUG_PROJECT_ID = ? "; queryList.add(pid);}
        if (crnum!=null) { sql += " and bug_cr_num like ? "; queryList.add("%"+crnum.trim()+"%");}
        if (tasknum!=null) { sql += " and bug_task_num  like ? "; queryList.add("%"+tasknum.trim()+"%");}
        if (testerid!=0) { sql += " and qa_tester_id = ? ";queryList.add(testerid);}
        if (devid!=0) { sql += " and qa_assignee_id = ?  ";queryList.add(devid);}

        int count =jdbcTemplate.query(sql,queryList.toArray(),new BugRowMapper()).size();
        return count;
    }

    @Override
    public Bug findById(int id) {
        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0 and bug_id = ?";
        Bug bug = jdbcTemplate.queryForObject(sql,new BugRowMapper(),id);
        return bug;
    }

    @Override
    public int create(String pname,String crname,String crnum, String tasknum, String oname, String description,
                      String rca, String solution, String developer, String tester,String bugStatus) {
        Date dt =new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date =bf.format(dt);

        String sql ="INSERT QA_BUGLIST(BUG_PROJECT_ID,BUG_CR_TYPE_ID,BUG_CR_NUM,BUG_TASK_NUM,QA_TYPE_ID,BUG_DESCRIPTION,BUG_RCA,BUG_SOLUTION,QA_ASSIGNEE_ID,QA_TESTER_ID,QA_CREATIONDT,QA_UPDATEDT,bug_status_id)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,pname,crname,crnum,tasknum,oname,description,rca,solution,developer,tester,date,date,bugStatus);
    }

    @Override
    public int update(long id, String pname,String crname,String crnum,String oname, String tasknum,
                      String description, String rca, String solution, String developer, String tester,String bugStatus){


        String sql2= "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag,status_des\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0 and bug_id = ?";
        Bug bug = jdbcTemplate.queryForObject(sql2,new BugRowMapper(),id);

        String rcaold =bug.getRca();
        String solutionold = bug.getSolution();
        Date dt =new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date =bf.format(dt);

        rca= rcaold+" \n =====" +date+"=========== \n"+rca;
        solution = solutionold +" \n =====" +date+"=========== \n"+solution;

        String sql = "update QA_BUGLIST set BUG_PROJECT_ID = ?,BUG_CR_TYPE_ID=?, BUG_CR_NUM =?, QA_TYPE_ID =?,BUG_TASK_NUM =?,BUG_DESCRIPTION=?,BUG_RCA=?,BUG_SOLUTION= ?,QA_ASSIGNEE_ID = ? ,QA_TESTER_ID =? ,QA_UPDATEDT =? ,Bug_status_id = ? where BUG_ID = ?";
        return jdbcTemplate.update(sql,pname,crname,crnum,oname,tasknum,description,rca,solution,developer,tester,date,bugStatus,id);
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update QA_BUGLIST set BUG_DELETED_FLAG = 1,  BUG_DELETED_COMMENT = '逻辑删除' where BUG_ID = ?";
         int count = jdbcTemplate.update(sql,id);
        return count;
    }
}
