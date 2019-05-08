package com.example.demo.controller;

import com.example.demo.bean.dto.BugInsertRequest;
import com.example.demo.bean.dto.BugRequest;
import com.example.demo.bean.dto.BugSearchRequest;
import com.example.demo.bean.po.Response;
import com.example.demo.service.BugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("bug")
@Api(value = "对bug进行增删查改", description = "查询bug信息，对bug进行增删查改", position = 0)
public class BugController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BugService bugService;


    @ApiOperation(value = "展示bug列表请求接口", notes = "展示bug列表请求接口")
    @GetMapping(value="/showallbugs")
    public Response findAll() {
        Response response = bugService.getBugs();
        return response;
    }


    @ApiOperation(value = "根据条件查询Bug且进行分页", notes = "根据条件查询Bug且进行分页")
    @ApiImplicitParam(dataType = "BugSearchRequest", name = "bugSearchRequest", value = "根据条件查询Bug且进行分页", required = true)
    @PostMapping(value="/showbugs")
    public Response findBugsByConditions(@RequestBody BugSearchRequest bugSearchRequest) {
        Response response = bugService.getBugsByPageByConditions(bugSearchRequest);
        return response;
    }


    @ApiOperation(value = "根据id查询Bug的信息", notes = "根据id查询Bug的信息")
    @ApiImplicitParam(dataType = "BugRequest", name = "bugRequest", value = "根据id查询Bug的信息", required = true)
    @PostMapping(value="/getBugByid")
    public Response getBugByid(@RequestBody BugRequest bugRequest) {
        Response response = bugService.getBugByid(bugRequest);
        return response;
    }

    @ApiOperation(value = "增加bug信息", notes = "增加bug信息")
    @ApiImplicitParam(dataType = "BugInsertRequest", name = "bugInsertRequest", value = "增加bug信息", required = true)
    @PostMapping(value="/addBug")
    public Response add(@RequestBody BugInsertRequest bugInsertRequest) {
        Response response = bugService.addBug(bugInsertRequest);
        return response;
    }



    @ApiOperation(value = "更新bug信息", notes = "更新bug信息")
    @ApiImplicitParam(dataType = "BugInsertRequest", name = "bugInsertRequest", value = "更新bug信息", required = true)
    @PostMapping(value="/updateBug")
    public Response update(@RequestBody BugInsertRequest bugInsertRequest) {
        Response response = bugService.UpdateBugById(bugInsertRequest);
        return response;
    }


}
