package com.example.demo.controller;

import com.example.demo.bean.dto.Task;
import com.example.demo.bean.dto.TaskSearchRequest;
import com.example.demo.bean.dto.TaskSearchRequest;
import com.example.demo.bean.po.Response;
import com.example.demo.service.TaskService;
import com.example.demo.service.TaskService;
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
@RequestMapping("task")
@Api(value = "对task进行增删查改", description = "查询task信息，对task进行增删查改", position = 1)
public class TaskController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TaskService taskService;


    @ApiOperation(value = "展示task列表请求接口", notes = "展示task列表请求接口")
    @GetMapping(value="/showalltasks")
    public Response findAll() {
        Response response = taskService.getTasks();
        return response;
    }


    @ApiOperation(value = "根据条件查询Task且进行分页", notes = "根据条件查询Task且进行分页")
    @ApiImplicitParam(dataType = "TaskSearchRequest", name = "SearchRequest", value = "根据条件查询Task且进行分页", required = true)
    @PostMapping(value="/showTasks")
    public Response findTasksByConditions(@RequestBody TaskSearchRequest Searchcondtion) {
        Response response = taskService.getTasksByPageByConditions(Searchcondtion);
        return response;
    }

    @ApiOperation(value = "根据id查询Task的信息", notes = "根据id查询Task的信息")
    @ApiImplicitParam(dataType = "Task", name = "task", value = "根据id查询Task的信息", required = true)
    @PostMapping(value="/getTaskByid")
    public Response getTaskByid(@RequestBody Task task) {
        Response response = taskService.getTaskByid(task);
        return response;
    }

    @ApiOperation(value = "增加Task信息", notes = "增加Task信息")
    @ApiImplicitParam(dataType = "Task", name = "task", value = "增加Task信息", required = true)
    @PostMapping(value="/addTask")
    public Response add(@RequestBody Task task) {
        Response response = taskService.addTask(task);
        return response;
    }



    @ApiOperation(value = "更新Task信息", notes = "更新Task信息")
    @ApiImplicitParam(dataType = "Task", name = "task", value = "更新Task信息", required = true)
    @PostMapping(value="/updateTask")
    public Response update(@RequestBody Task task) {
        Response response = taskService.UpdateTaskById(task);
        return response;
    }

}
