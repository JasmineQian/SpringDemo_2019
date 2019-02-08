package com.example.demo.serviceImp;

import com.example.demo.mapper.userMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImp implements userService {

	@Autowired
	private userMapper userMapper;

	public List<User> findAll() {
		List<User> list = userMapper.findAll();
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
