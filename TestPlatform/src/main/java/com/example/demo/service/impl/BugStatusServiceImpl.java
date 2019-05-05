package com.example.demo.service.impl;

import com.example.demo.bean.dto.BugStatus;
import com.example.demo.bean.dto.BugStatusResponse;
import com.example.demo.common.Message;
import com.example.demo.common.Response;
import com.example.demo.mapper.BugStatusMapper;
import com.example.demo.service.BugStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugStatusServiceImpl implements BugStatusService {


    @Autowired
    private BugStatusMapper bugstatusMapper;


    @Override
    public Response getBugStatus() {
        BugStatusResponse re = new BugStatusResponse();
        List<BugStatus> lists = bugstatusMapper.getBugStatus();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setLists(lists);
        return re;
    }

    @Override
    public Response getBugByid(BugStatus bugstatus) {
        BugStatusResponse re = new BugStatusResponse();
        Response response = new Response();
        if (0 == bugstatus.getId() || "".equals(bugstatus.getId())) {
            response.setCode(Message.VAR_CODE);
            response.setMsg(Message.VAR_MESSAGE);
            return response;
        }
        BugStatus status = bugstatusMapper.getBugStatusByid(bugstatus.getId());
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setInfo(status);
        return re;
    }
}
