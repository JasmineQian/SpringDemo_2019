package com.example.demo.service.impl;

import com.example.demo.bean.dto.Task;
import com.example.demo.bean.dto.TaskSearchRequest;
import com.example.demo.bean.po.Page;
import com.example.demo.bean.po.Response;
import com.example.demo.bean.po.ResponseBean;
import com.example.demo.common.Message;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Value("${sys.name}")
    private String uid;

    @Value("${sys.PageSize}")
    private int pagesize;

    @Autowired
    private TaskMapper taskMapper;


    @Override
    public ResponseBean getTasks() {
        ResponseBean re = new ResponseBean();
        List<Task> lists = taskMapper.getTasks();
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getTasksByPage(Page page) {
        ResponseBean re = new ResponseBean();
        List<Task> lists = taskMapper.getTasksByPage(page);
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getTasksByPageByConditions(TaskSearchRequest SearchRequest) {
        ResponseBean re = new ResponseBean();

        if (SearchRequest.getCrnum() != null) {
            SearchRequest.setCrnum(SearchRequest.getCrnum().trim());
        }

        if (SearchRequest.getCurrentPage() <= 0)
            SearchRequest.setCurrentPage(1);

        if (SearchRequest.getPageSize() <= 0)
            SearchRequest.setPageSize(pagesize);

        List<Task> lists = taskMapper.getTasksByPageByConditions(SearchRequest);
        System.out.println("========================");
        System.out.println(lists.toString());
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(lists);
        return re;
    }

    @Override
    public ResponseBean getTaskByid(Task task) {
        ResponseBean re = new ResponseBean();
        if (0 == task.getTaskid()) {
            re.setCode(Message.ID_NOT_EXIST_CODE);
            re.setMsg(Message.ID_NOT_EXIST_MESSAGE);
            return re;
        }


        Task taskinfo = taskMapper.getTaskByid(task.getTaskid());
        re.setCode(Message.SUCCESS_CODE);
        re.setMsg(Message.SUCCESS_MESSAGE);
        re.setData(taskinfo);
        return re;
    }

    @Override
    public Response addTask(Task task) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);


        task.setCreationdt(date);
        task.setUpdatedt(date);
        task.setCreationuid(uid);
        task.setUpdateuid(uid);
        Response response = new Response();
        int a = taskMapper.insert(task);
        if (a > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;

    }

    @Override
    public Response UpdateTaskById(Task record) {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);

        Task task = taskMapper.getTaskByid((int) record.getTaskid());
        Response response = new Response();
        if (task == null) {
            response.setCode(Message.ID_NOT_EXIST_CODE);
            response.setMsg(Message.ID_NOT_EXIST_MESSAGE);
            return response;
        }


        if (record.getTask_pid() == 0 || record.getTask_tid() == 0) {
            response.setCode(Message.VAR_NOT_EXIST_CODE);
            response.setMsg(Message.VAR_NOT_EXIST_MESSAGE);
            return response;
        }


        record.setNote(record.getNote());
        record.setUpdatedt(date);
        record.setUpdateuid(uid);



        int a = taskMapper.updateById(record);
        if (a > 0) {
            response.setCode(Message.SUCCESS_CODE);
            response.setMsg(Message.SUCCESS_MESSAGE);
        } else {
            response.setCode(Message.ERROR_CODE);
            response.setMsg(Message.ERROR_MESSAGE);

        }
        return response;
    }
}

