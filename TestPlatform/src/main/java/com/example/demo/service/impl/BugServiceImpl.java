package com.example.demo.service.impl;

import com.example.demo.bean.dto.*;
import com.example.demo.common.Message;
import com.example.demo.common.Page;
import com.example.demo.common.Response;
import com.example.demo.mapper.BugMapper;
import com.example.demo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class BugServiceImpl implements BugService {

    @Value("${sys.name}")
    private String uid;

    @Autowired
    private BugMapper bugMapper;


    @Override
    public Response getBugs() {
        BugResponse re = new BugResponse();
        List<Bug> lists = bugMapper.getBugs();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setBuglists(lists);
        return re;
    }

    @Override
    public Response getBugsByPage(Page page) {
        BugResponse re = new BugResponse();
        List<Bug> lists = bugMapper.getBugsByPage(page);
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setBuglists(lists);
        return re;
    }

    @Override
    public Response getBugsByPageByConditions(BugSearchRequest BugSearchRequest, Page page) {
        BugResponse re = new BugResponse();
        List<Bug> lists = bugMapper.getBugsByPage(page);
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setBuglists(lists);
        return re;
    }

    @Override
    public Response getBugByid(BugRequest bugRequest) {
        BugResponse re = new BugResponse();
        Response response = new Response();
        if (null == bugRequest.getId()) {
            response.setCode(Message.ID_CODE);
            response.setMsg(Message.ID_MESSAGE);
            return response;
        }


        Bug buginfo = bugMapper.getBugByid(bugRequest.getId());
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setBuginfo(buginfo);
        return re;
    }

    @Override
    public Response addBug(BugInsertRequest bugInsertRequest) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);

        Bug bug = new Bug();
        bug.setPname(bugInsertRequest.getPname());
        bug.setCrname(bugInsertRequest.getCrname());
        bug.setCrnum(bugInsertRequest.getCrnum());
        bug.setTasknum(bugInsertRequest.getTasknum());
        bug.setTester(bugInsertRequest.getTester());
        bug.setDeveloper(bugInsertRequest.getDeveloper());
        bug.setOname(bugInsertRequest.getOname());
        bug.setDescription(bugInsertRequest.getDescription());
        bug.setRca(bugInsertRequest.getRca());
        bug.setSolution(bugInsertRequest.getSolution());


        bug.setCreationdt(date);
        bug.setUpdatedt(date);
        bug.setCreationuid(uid);
        bug.setUpdateuid(uid);


        Response response = new Response();
        int a = bugMapper.insert(bug);
        if (a > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;
    }

    @Override
    public Response UpdateBugById(BugInsertRequest bugInsertRequest) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);


        Bug bug = bugMapper.getBugByid((int) bugInsertRequest.getId());
        System.out.println(bug);
        bug.setPname(bugInsertRequest.getPname());
        bug.setCrname(bugInsertRequest.getCrname());
        bug.setCrnum(bugInsertRequest.getCrnum());
        bug.setTasknum(bugInsertRequest.getTasknum());
        bug.setTester(bugInsertRequest.getTester());
        bug.setDeveloper(bugInsertRequest.getDeveloper());
        bug.setOname(bugInsertRequest.getOname());
        bug.setDescription(bugInsertRequest.getDescription());
        bug.setRca(bugInsertRequest.getRca());
        bug.setSolution(bugInsertRequest.getSolution());
        bug.setBugStatus(bugInsertRequest.getBugStatus());
        bug.setUpdatedt(date);
        bug.setUpdateuid(uid);
        System.out.println(bug);

        Response response = new Response();
        int a = bugMapper.updateById(bug);
        if (a > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;
    }

}
