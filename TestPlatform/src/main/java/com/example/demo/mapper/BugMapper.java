package com.example.demo.mapper;

import com.example.demo.bean.dto.Bug;
import com.example.demo.common.Page;

import java.util.List;
public interface BugMapper {

    List<Bug> getBugs();

    List<Bug> getBugsByPage(Page page);

    List<Bug> getBugsByPageByConditions(Bug record,Page page);

    Bug getBugByid(Integer id);

    int insert(Bug record);

    int updateById(Bug record);
}
