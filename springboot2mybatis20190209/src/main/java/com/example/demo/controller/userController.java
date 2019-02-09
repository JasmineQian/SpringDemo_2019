package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.impl.userServiceImp;
import com.example.demo.pojo.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Api(tags = {"user接口"})
@Controller
@RequestMapping("user")
public class userController {


	@Autowired
	private userServiceImp userService;

    @ApiOperation(value = "显示全部用户的信息且进行分页")
    @PostMapping(value = "userLists")
	@ResponseBody
	public Result showUsers(@RequestBody Page page) {
    	Result result =new Result();
    	int currentPage = page.getCurrentPage();
    	int pageSize= page.getPageSize();
    	int starter =page.getStarter(currentPage,pageSize);
        System.out.println(starter);

    	PageList pageList = new PageList();
        if(currentPage == 0){currentPage=1;}
        if(pageSize == 0){pageSize=30;}
        int TotalRows = userService.countAll();


        pageList.setPage(currentPage);
        pageList.setTotalRows(TotalRows);
        int pages= 0;

        if(TotalRows % pageSize == 0){ pages = TotalRows / pageSize;}
        else { pages = TotalRows / pageSize +1 ;}
        System.out.println("目前分页的总页数是"+pages);
        pageList.setPages(pages);

        List<User> list=userService.findAll(page);
        pageList.setList(list);
		result.setCode("000");
		result.setMsg("success");
		result.setData(pageList);
		return result;
	}


    @ApiOperation(value = "findAllByCondition")
    @PostMapping(value = "findAllByCondition")
    @ResponseBody
    public Result findAllByCondition(@RequestBody User user) {
        Result result =new Result();
        List<User> list= userService.findAllByCondition(user);
        if(list.size()>0){
        result.setCode("000");
        result.setMsg("success");
        result.setData(list);
        }
        else{
            result.setCode("E01");
            result.setMsg("chaxunbudao");
            result.setData(list);

        }
        return result;
    }


    @ApiOperation(value = "findAllByConditions")
    @PostMapping(value = "findAllByConditions")
    @ResponseBody
    public Result findAllByConditions(@RequestBody User user) {
        Result result =new Result();
        List<User> list= userService.findAllByConditions(user);
        if(list.size()>0){
            result.setCode("000");
            result.setMsg("success");
            result.setData(list);
        }
        else{
            result.setCode("E01");
            result.setMsg("chaxunbudao");
            result.setData(list);

        }
        return result;
    }

    @ApiOperation(value = "显示全部用户的tiaoshu")
    @RequestMapping(value = "countAll", method = RequestMethod.GET)
    @ResponseBody
    public Result countAll() {
        Result result =new Result();
        int countAll = userService.countAll();
        result.setCode("000");
        result.setMsg("success");
        result.setData(countAll);
        return result;
    }

    @ApiOperation(value = "显示全部用户的信息")
	@GetMapping("selectAll")
	@ResponseBody
	public Result selectAll() {
		Result result =new Result();
		List<User> list = userService.selectAll();
		result.setCode("000");
		result.setMsg("success");
		result.setData(list);
		return result;
	}

    @ApiOperation(value = "根据ID查询用户的信息")
	@PostMapping("selectById")
	@ResponseBody
	public Result selectById(@RequestBody User user) {
		Result result =new Result();
		List<User> list = userService.selectById(user.getId());
		if(list.size()==1){
		result.setCode("000");
		result.setMsg("success");
		result.setData(list);
	}else if(list.size()==0){
			result.setCode("E01");
			result.setMsg("输入的id找不到有效用户");
			result.setData(null);
		}else {
			result.setCode("E02");
			result.setMsg("输入的id找到大于1个有效用户");
			result.setData(list);
		}
		return result;
	}

    @ApiOperation(value = "创建新用户信息")
	@PostMapping("create")
	@ResponseBody
	public Result create(@RequestBody User user) {
		Result result =new Result();
		int count = userService.create(user);
		if (count>0)
		{   result.setCode("000");
			result.setMsg("success");
			}
		else
		{result.setCode("E01");
		result.setMsg("创建用户信息失败");
		}
		return result;
	}

    @ApiOperation(value = "根据ID更新用户信息")
    @PostMapping("updateUserById")
    @ResponseBody
    public Result updateUserById(@RequestBody User user) {
		Result result =new Result();
        int count = userService.updateUserById(user);
        System.out.println(count);
		if (count>0)
		{   result.setCode("000");
			result.setMsg("success");
		}
		else
		{result.setCode("E01");
			result.setMsg("根据ID更新用户信息失败");
		}
		return result;
    }

    @ApiOperation(value = "根据ID删除用户信息")
    @PostMapping("deleteUserById")
    @ResponseBody
    public Result deleteUserById(@RequestBody User user) {
		Result result =new Result();
        int count = userService.deleteUserById(user.getId());
        System.out.println(count);
		if (count>0)
		{   result.setCode("000");
			result.setMsg("success");
		}
		else
		{result.setCode("E01");
			result.setMsg("删除用户失败");
		}
		return result;
    }



}
