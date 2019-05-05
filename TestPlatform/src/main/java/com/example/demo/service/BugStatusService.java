package com.example.demo.service;

import com.example.demo.bean.dto.BugStatus;
import com.example.demo.common.Response;

public interface BugStatusService {

    Response getBugStatus();

    Response getBugByid(BugStatus bugstatus);
}
