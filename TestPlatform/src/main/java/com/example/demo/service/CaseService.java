package com.example.demo.service;

import com.example.demo.bean.dto.Case;
import com.example.demo.bean.dto.CaseSearchPage;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;

public interface CaseService {

    ResponseBean getCasesBytaskid(int id);

    ResponseBean getCasesByPage(CaseSearchPage caseSearchPage);

    ResponseBean getCaseByid(int id);

    Response addCase(Case record);

    Response UpdateCaseById(Case record);
}
