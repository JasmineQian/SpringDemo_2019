package com.example.demo.service;

import com.example.demo.bean.dto.Task;
import com.example.demo.bean.dto.TaskSearchRequest;
import com.example.demo.bean.po.Page;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;

public interface TaskService {

    ResponseBean getTasks();

    ResponseBean getTasksByPage(Page page);

    ResponseBean getTasksByPageByConditions(TaskSearchRequest SearchRequest);

    ResponseBean getTaskByid(Task task);

    Response addTask(Task task);

    Response UpdateTaskById(Task task);
}
