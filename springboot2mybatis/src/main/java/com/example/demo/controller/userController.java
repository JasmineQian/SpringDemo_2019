package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.serviceImp.userServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Api(tags = {"demo接口"})
@Controller
@RequestMapping("user")
public class userController {

	@Autowired
	private userServiceImp userService;

    @ApiOperation(value = "显示全部用户的信息倒序")
    @RequestMapping("userLists")
	@ResponseBody
	public List<User> showUsers() {
		List<User> list = userService.findAll();
		return list;
	}

    @ApiOperation(value = "显示全部用户的信息")
	@RequestMapping("selectAll")
	@ResponseBody
	public List<User> selectAll() {
		List<User> list = userService.selectAll();
		return list;
	}

    @ApiOperation(value = "根据ID查询用户的信息")
	@RequestMapping("selectById")
	@ResponseBody
	public List<User> selectById(int id) {
		List<User> list = userService.selectById(300);
		return list;
	}

    @ApiOperation(value = "创建新用户信息")
	@PostMapping("create")
	@ResponseBody
	public String create(User user) {
		int count = userService.create(user);
		System.out.println(count);
		if (count>0)
		return ("成功添加"+count+"条记录");
		else
			return "添加用户失败";
	}

    @ApiOperation(value = "根据ID更新用户信息")
    @PostMapping("updateUserById")
    @ResponseBody
    public String updateUserById(User user) {
        int count = userService.updateUserById(user);
        System.out.println(count);
        if (count>0)
            return ("成功更新"+count+"条记录");
        else
            return "更新用户失败";
    }

    @ApiOperation(value = "根据ID删除用户信息")
    @PostMapping("deleteUserById")
    @ResponseBody
    public String deleteUserById(int id) {
        int count = userService.deleteUserById(id);
        System.out.println(count);
        if (count>0)
            return ("成功删除"+count+"条记录");
        else
            return "删除用户失败";
    }



}
