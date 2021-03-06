package com.example.demo.service.impl;

import com.example.demo.mapper.userMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.userService;
import com.example.demo.pojo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImp implements userService {

	@Autowired
	private userMapper userMapper;

	public List<User> findAll(Page page) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        List<User> list = userMapper.findAll(page);
        return list;

	}

    @Override
    public List<User> findAllByConditions(User user) {
        List<User> list = userMapper.findAllByConditions(user);
        return list;
    }

    @Override
    public List<User> findAllByCondition(User user) {
        List<User> list = userMapper.findAllByCondition(user);
        return list;
    }


    @Override
	public List<User> selectAll() {
		List<User> list = userMapper.selectAll();
		return list;
	}

	@Override
	public List<User> selectById(int id) {
		List<User> list = userMapper.selectById(id);
		return list;
	}

    @Override
    public int countAll() {
        int countNums = userMapper.countAll();
        return countNums;
    }


    @Override
	public int create(User user) {
		int count = userMapper.create(user);
		return count;
	}

	@Override
	public int updateUserById(User user) {
		int count = userMapper.updateUserById(user);
		return count;
	}

	@Override
	public int deleteUserById(int id) {
		int count = userMapper.deleteUserById(id);
		return count;
	}

}
