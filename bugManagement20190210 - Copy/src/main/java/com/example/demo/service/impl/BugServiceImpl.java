package com.example.demo.service.impl;


import com.example.demo.bean.Bug;
import com.example.demo.bean.SearchResult;
import com.example.demo.jdbc.BugRowMapper;
import com.example.demo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BugServiceImpl implements BugService {



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Bug> findAllbyPage(int pageon, int pid, int crid, int oid) {
        SearchResult searchResult = new SearchResult();
        int start =(pageon-1)*20;
        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag  \n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "where bug_deleted_flag =0  ";
        List <Object> queryList=new ArrayList<Object>();
        if (pid!=0) { sql += " and BUG_PROJECT_ID = ? "; queryList.add(pid);}
        if (crid!=0) { sql += " and bug_cr_type_id = ? ";queryList.add(crid);}
        if (oid!=0) { sql += " and object_id = ?  ";queryList.add(oid);}
        String sql2 =sql +" order by 1 desc limit "+ start +" , 20";

        List<Bug> lists =jdbcTemplate.query(sql2,queryList.toArray(),new BugRowMapper());
        searchResult.getList(lists);
        System.out.println(searchResult);
        System.out.println(sql2);
        return lists;
    }


    @Override
    public int countAll(int pid, int crid, int oid){

        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag  \n" +
                "from qa_buglist \n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "where bug_deleted_flag =0  ";
        List <Object> queryList=new ArrayList<Object>();
        if (pid!=0) { sql += " and BUG_PROJECT_ID = ? "; queryList.add(pid);}
        if (crid!=0) { sql += " and bug_cr_type_id = ? ";queryList.add(crid);}
        if (oid!=0) { sql += " and object_id = ?  ";queryList.add(oid);}

        int count =jdbcTemplate.query(sql,queryList.toArray(),new BugRowMapper()).size();

/*        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql,countCallback);
        int count = countCallback.getRowCount();*/
        return count;
    }

    @Override
    public Bug findById(int id) {
        String sql = "SELECT BUG_ID,PROJECT_NAME,CR_NAME,BUG_CR_NUM,BUG_TASK_NUM,OBJECT_NAME,BUG_DESCRIPTION,BUG_RCA,BUG_SOLUTION,B.EMPLOY_NAME DEVELOPER,A.EMPLOY_NAME TESTER,QA_CREATIONDT,QA_UPDATEDT,BUG_DELETED_FLAG\n" +
                "FROM QA_BUGLIST  JOIN QA_PROJECT ON BUG_PROJECT_ID = PROJECT_ID\n" +
                "JOIN QA_CRTYPE ON CR_ID = BUG_CR_TYPE_ID\n" +
                "JOIN QA_RTYPE ON OBJECT_ID = QA_TYPE_ID\n" +
                "JOIN QA_EMPLOY A ON A.EMPLOY_ID = QA_TESTER_ID AND A.EMPLOY_GROUP = 1 \n" +
                "JOIN QA_EMPLOY B ON B.EMPLOY_ID= QA_ASSIGNEE_ID AND B.EMPLOY_GROUP = 2\n" +
                "WHERE BUG_DELETED_FLAG =0 and BUG_ID = ?";
        Bug bug = jdbcTemplate.queryForObject(sql,new BugRowMapper(),id);
        return bug;
    }

    @Override
    public int create(String pname,String crname,String crnum, String tasknum, String oname, String description, String rca, String solution, String developer, String tester) {
        Date dt =new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date =bf.format(dt);

        String sql ="INSERT QA_BUGLIST(BUG_PROJECT_ID,BUG_CR_TYPE_ID,BUG_CR_NUM,BUG_TASK_NUM,QA_TYPE_ID,BUG_DESCRIPTION,BUG_RCA,BUG_SOLUTION,QA_ASSIGNEE_ID,QA_TESTER_ID,QA_CREATIONDT,QA_UPDATEDT)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,pname,crname,crnum,tasknum,oname,description,rca,solution,developer,tester,date,date);
    }

    @Override
    public int update(long id, String pname,String crname,String crnum,String oname, String tasknum,  String description, String rca, String solution, String developer, String tester){
        Date dt =new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date =bf.format(dt);
        String sql = "update QA_BUGLIST set BUG_PROJECT_ID = ?,BUG_CR_TYPE_ID=?, BUG_CR_NUM =?, QA_TYPE_ID =?,BUG_TASK_NUM =?,BUG_DESCRIPTION=?,BUG_RCA=?,BUG_SOLUTION= ?,QA_ASSIGNEE_ID = ? ,QA_TESTER_ID =? ,QA_UPDATEDT =? where BUG_ID = ?";
        System.out.println("sql:"+sql);
        System.out.println(pname);
        System.out.println(crname);
        System.out.println(crnum);
        System.out.println(oname);
        System.out.println(tasknum);
        System.out.println(description);
        System.out.println(rca);
        System.out.println(solution);
        System.out.println(developer);
        System.out.println(tester);
        System.out.println(date);
        System.out.println(id);
        return jdbcTemplate.update(sql,pname,crname,crnum,oname,tasknum,description,rca,solution,developer,tester,date,id);
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update QA_BUGLIST set BUG_DELETED_FLAG = 1,  BUG_DELETED_COMMENT = '逻辑删除' where BUG_ID = ?";
         int count = jdbcTemplate.update(sql,id);
        return count;
    }
}
