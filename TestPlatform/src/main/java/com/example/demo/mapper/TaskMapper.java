package com.example.demo.mapper;

import com.example.demo.bean.dto.Task;
import com.example.demo.bean.dto.TaskSearchRequest;
import com.example.demo.bean.po.Page;

import java.util.List;

public interface TaskMapper {

    List<Task> getTasks();

    List<Task> getTasksByPage(Page page);

    List<Task> getTasksByPageByConditions(TaskSearchRequest record);

    Task getTaskByid(Integer id);

    int insert(Task record);

    int updateById(Task record);
}
