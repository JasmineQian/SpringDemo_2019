package com.example.demo.service.impl;

import com.example.demo.bean.dto.Case;
import com.example.demo.bean.dto.CaseSearchPage;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.mapper.CaseMapper;
import com.example.demo.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {


    @Value("${sys.name}")
    private String uid;

    @Value("${sys.PageSize}")
    private int pagesize;

    @Autowired
    private CaseMapper caseMapper;


    @Override
    public ResponseBean getCasesBytaskid(int id) {
        return null;
    }

    @Override
    public ResponseBean getCasesByPage(CaseSearchPage caseSearchPage) {
        ResponseBean re = new ResponseBean();

        if (caseSearchPage.getTaskid() == 0) {
            re.setCode(Message.ID_NOT_EXIST_CODE);
            re.setMsg(Message.ID_NOT_EXIST_MESSAGE);
            return re;
        }


        if (caseSearchPage.getPageon() <= 0)
            caseSearchPage.setPageon(1);

        if (caseSearchPage.getPageNumber() <= 0)
            caseSearchPage.setRow(pagesize);

        List<Case> lists = caseMapper.getCasesByPage(caseSearchPage);
        System.out.println("========================");
        System.out.println(lists);
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getCaseByid(int id) {
        ResponseBean re = new ResponseBean();
        if (0 == id) {
            re.setCode(Message.ID_NOT_EXIST_CODE);
            re.setMsg(Message.ID_NOT_EXIST_MESSAGE);
            return re;
        }
        Case record = caseMapper.getCaseByid(id);
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(record);
        return re;
    }

    @Override
    public Response addCase(Case record) {
        return null;
    }

    @Override
    public Response UpdateCaseById(Case record) {
        return null;
    }
}
