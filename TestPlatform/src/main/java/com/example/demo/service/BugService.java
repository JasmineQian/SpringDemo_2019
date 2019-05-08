package com.example.demo.service;

import com.example.demo.bean.dto.BugInsertRequest;
import com.example.demo.bean.dto.BugRequest;
import com.example.demo.bean.dto.BugSearchRequest;
import com.example.demo.bean.po.Page;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;

public interface BugService {

    ResponseBean getBugs();

    ResponseBean getBugsByPage(Page page);

    ResponseBean getBugsByPageByConditions(BugSearchRequest BugSearchRequest);

    ResponseBean getBugByid(BugRequest bugRequest);

    Response addBug(BugInsertRequest bugInsertRequest);

    Response UpdateBugById(BugInsertRequest bugInsertRequest);


}
