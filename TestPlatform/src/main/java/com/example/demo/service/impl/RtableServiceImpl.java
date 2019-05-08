package com.example.demo.service.impl;

import com.example.demo.bean.dto.Rtable;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.mapper.RtableMapper;
import com.example.demo.service.RtableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RtableServiceImpl implements RtableService {


    @Autowired
    private RtableMapper rtableMapper;


    @Override
    public ResponseBean getBugStatus() {
        ResponseBean re = new ResponseBean();
        List<Rtable> lists = rtableMapper.getBugStatus();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getBugByid(Rtable bugstatus) {
        ResponseBean response = new ResponseBean();
        if (0 == bugstatus.getId() || "".equals(bugstatus.getId())) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }
        Rtable status = rtableMapper.getBugStatusByid(bugstatus.getId());
        response.setCode(Message.SUCCESS_CODE);
        response.setMsg(Message.SUCCESS_MESSAGE);
        response.setData(status);
        return response;
    }

    @Override
    public ResponseBean getProject() {
        ResponseBean re = new ResponseBean();
        List<Rtable> lists = rtableMapper.getProject();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getProjectByid(Rtable rtable) {
        ResponseBean response = new ResponseBean();
        if (0 == rtable.getId() || "".equals(rtable.getId())) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }
        Rtable status = rtableMapper.getProjectByid(rtable.getId());
        response.setCode(Message.SUCCESS_CODE);
        response.setMsg(Message.SUCCESS_MESSAGE);
        response.setData(status);
        return response;
    }

    @Override
    public ResponseBean getCRStatus() {
        ResponseBean re = new ResponseBean();
        List<Rtable> lists = rtableMapper.getCRStatus();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getCRByid(Rtable rtable) {
        ResponseBean response = new ResponseBean();
        if (0 == rtable.getId() || "".equals(rtable.getId())) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }
        Rtable status = rtableMapper.getCRByid(rtable.getId());
        response.setCode(Message.SUCCESS_CODE);
        response.setMsg(Message.SUCCESS_MESSAGE);
        response.setData(status);
        return response;


    }

    @Override
    public ResponseBean getTestType() {
        ResponseBean re = new ResponseBean();
        List<Rtable> lists = rtableMapper.getTestType();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getTestTypeByid(Rtable rtable) {
        ResponseBean response = new ResponseBean();
        if (0 == rtable.getId() || "".equals(rtable.getId())) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }
        Rtable status = rtableMapper.getTestTypeByid(rtable.getId());
        response.setCode(Message.SUCCESS_CODE);
        response.setMsg(Message.SUCCESS_MESSAGE);
        response.setData(status);
        return response;
    }

    @Override
    public ResponseBean getCasePirority() {
        ResponseBean re = new ResponseBean();
        List<Rtable> lists = rtableMapper.getCasePirority();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getCasePirorityByid(Rtable rtable) {
        ResponseBean response = new ResponseBean();
        if (0 == rtable.getId() || "".equals(rtable.getId())) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }
        Rtable status = rtableMapper.getCasePirorityByid(rtable.getId());
        response.setCode(Message.SUCCESS_CODE);
        response.setMsg(Message.SUCCESS_MESSAGE);
        response.setData(status);
        return response;
    }
}
