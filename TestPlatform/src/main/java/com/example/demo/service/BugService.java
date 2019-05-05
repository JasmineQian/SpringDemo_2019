package com.example.demo.service;

import com.example.demo.bean.dto.BugInsertRequest;
import com.example.demo.bean.dto.BugRequest;
import com.example.demo.bean.dto.BugSearchRequest;
import com.example.demo.common.Page;
import com.example.demo.common.Response;

public interface BugService {

    Response getBugs();

    Response getBugsByPage(Page page);

    Response getBugsByPageByConditions(BugSearchRequest BugSearchRequest,Page page);

    Response getBugByid(BugRequest bugRequest);

    Response addBug(BugInsertRequest bugInsertRequest);

    Response UpdateBugById(BugInsertRequest bugInsertRequest);


}
