package com.example.demo.service;

import com.example.demo.bean.dto.Rtable;
import com.example.demo.bean.po.ResponseBean;

public interface RtableService {


    //********BugStatus*************
    ResponseBean getBugStatus();

    ResponseBean getBugByid(Rtable rtable);

    //********Project name*************
    ResponseBean getProject();

    ResponseBean getProjectByid(Rtable rtable);

    //********CR name*************
    ResponseBean getCRStatus();

    ResponseBean getCRByid(Rtable rtable);

    //********Test Type*************
    ResponseBean getTestType();

    ResponseBean getTestTypeByid(Rtable rtable);

    //********Case Pirority*************
    ResponseBean getCasePirority();

    ResponseBean getCasePirorityByid(Rtable rtable);

}
