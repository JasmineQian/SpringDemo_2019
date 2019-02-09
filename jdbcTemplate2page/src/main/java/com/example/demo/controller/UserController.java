package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.util.List;

@Controller
public class UserController {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserService userService;


    @GetMapping("/listpage")
    @ResponseBody
    public List<User> PageList() {
        logger.info("查询User信息");
        List<User> list =userService.findAll();
        return list;
    }

    @GetMapping("/findAllbyPage")
    @ResponseBody
    public List<User> findAllbyPage(int pagenum, int pagerow) {
        if(pagenum == 0){pagenum=1;}
        if(pagerow == 0){pagenum=30;}

            List<User> list= userService.findAllbyPage(pagenum, pagerow );

        return list;
    }


    @GetMapping("/findAllbyPager")
    @ResponseBody
    public PageList findAllbyPager(int pagenum, int pagerow) {
        PageList pageList = new PageList();
        if(pagenum == 0){pagenum=1;}
        if(pagerow == 0){pagenum=30;}
        List<User> list= userService.findAllbyPage(pagenum, pagerow );
        int TotalRows = userService.countAll();
        pageList.setPage(pagenum);
        pageList.setTotalRows(TotalRows);
        int pages= 0;

        if(TotalRows % pagerow == 0){ pages = TotalRows / pagerow;}
        else { pages = TotalRows / pagerow +1 ;}
        System.out.println("目前分页的总页数是"+pages);
        pageList.setPages(pages);

        pageList.setList(list);
        return pageList;
    }


    @GetMapping("/countAll")
    @ResponseBody
    public int countAll() {

       // UserService.count
        int count = userService.countAll();
        return count;
    }

}
