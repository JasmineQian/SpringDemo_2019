package com.example.demo.mapper;

import com.example.demo.bean.dto.Case;
import com.example.demo.bean.dto.CaseSearchPage;
import com.example.demo.bean.po.Page;

import java.util.List;

public interface CaseMapper {

    List<Case> getCasesByPage(CaseSearchPage caseSearchPage);

    Case getCaseByid(Integer id);

    int insert(Case record);

    int updateById(Case record);
}
