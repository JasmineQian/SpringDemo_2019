package com.example.demo.mapper;

import com.example.demo.bean.dto.Rtable;

import java.util.List;

public interface RtableMapper {

    //********BugStatus*************
    List<Rtable> getBugStatus();
    Rtable getBugStatusByid(Integer id);


    //********Project name*************
    List<Rtable> getProject();
    Rtable getProjectByid(Integer id);

    //********CR name*************
    List<Rtable> getCRStatus();
    Rtable getCRByid(Integer id);


    //********Test Type*************
    List<Rtable> getTestType();
    Rtable getTestTypeByid(Integer id);

    //********Case Pirority*************
    List<Rtable> getCasePirority();
    Rtable getCasePirorityByid(Integer id);
}
