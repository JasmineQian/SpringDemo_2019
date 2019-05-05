package com.example.demo.jdbc;



import com.example.demo.entity.Bug;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BugRowMapper implements RowMapper<Bug> {
    @Override
    public Bug mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long id = resultSet.getInt("BUG_ID");
        String pname = resultSet.getString("PROJECT_NAME");
        String cr_name = resultSet.getString("CR_NAME");
        String crmnum = resultSet.getString("BUG_CR_NUM");
        String tasknum = resultSet.getString("BUG_TASK_NUM");
        String oname = resultSet.getString("OBJECT_NAME");
        String description = resultSet.getString("BUG_DESCRIPTION");
        String rca = resultSet.getString("BUG_RCA");
        String solution = resultSet.getString("BUG_SOLUTION");
        String developer = resultSet.getString("DEVELOPER");
        String tester = resultSet.getString("TESTER");
        String creationdt = resultSet.getString("QA_CREATIONDT");
        String updatedt = resultSet.getString("QA_UPDATEDT");
        String bugStatus = resultSet.getString("status_des");

        Bug bug = new Bug();
        bug.setId(id);
        bug.setPname(pname);
        bug.setOname(oname);
        bug.setCrname(cr_name);
        bug.setCrnum(crmnum);
        bug.setTasknum(tasknum);
        bug.setDescription(description);
        bug.setRca(rca);
        bug.setSolution(solution);
        bug.setDeveloper(developer);
        bug.setTester(tester);
        bug.setCreationdt(creationdt);
        bug.setUpdatedt(updatedt);
        bug.setBugStatus(bugStatus);

        return bug;

    }
}
