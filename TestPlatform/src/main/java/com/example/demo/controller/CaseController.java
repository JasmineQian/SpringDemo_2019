package com.example.demo.controller;


import com.example.demo.bean.dto.Case;
import com.example.demo.bean.dto.CaseSearchPage;
import com.example.demo.bean.po.Response;
import com.example.demo.service.CaseService;
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
@RequestMapping("case")
@Api(value = "对case进行增删查改", description = "查询case信息，对case进行增删查改", position = 2)
public class CaseController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CaseService caseService;

    @ApiOperation(value = "根据传入的taskid进行查询测试用例", notes = "根据传入的taskid进行查询测试用例")
    @ApiImplicitParam(dataType = "CaseSearchPage", name = "caseSearchPage", value = "输入对应的",required = true)
    @PostMapping(value="/showCases")
    public Response showCasesBytaskid(@RequestBody CaseSearchPage caseSearchPage) {
        Response response = caseService.getCasesByPage(caseSearchPage);
        return response;
    }


    @ApiOperation(value = "根据传入的caseid进行查询单个测试用例", notes = "根据传入的caseid进行查询单个测试用例")
    @ApiImplicitParam(dataType = "int", name = "id", value = "输入对应的caseid", paramType = "path",required = true)
    @GetMapping(value="/showCaseByid/{id}")
    public Response showCaseByid(@PathVariable int id) {
        Response response = caseService.getCaseByid(id);
        return response;
    }


    @ApiOperation(value = "增加Case信息", notes = "增加Case信息")
    @ApiImplicitParam(dataType = "Case", name = "record", value = "增加Case信息", required = true)
    @PostMapping(value="/addCase")
    public Response add(@RequestBody Case record) {
        Response response = caseService.addCase(record);
        return response;
    }



    @ApiOperation(value = "更新Case信息", notes = "更新Case信息")
    @ApiImplicitParam(dataType = "Case", name = "record", value = "更新Case信息", required = true)
    @PostMapping(value="/updateCase")
    public Response update(@RequestBody Case record) {
        Response response = caseService.UpdateCaseById(record);
        return response;
    }





}
