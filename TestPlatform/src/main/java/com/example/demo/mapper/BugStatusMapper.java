package com.example.demo.mapper;

import com.example.demo.bean.dto.BugStatus;

import java.util.List;

public interface BugStatusMapper {

    List<BugStatus> getBugStatus();

    BugStatus getBugStatusByid(Integer id);
}
