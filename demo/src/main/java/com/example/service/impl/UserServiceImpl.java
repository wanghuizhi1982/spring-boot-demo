package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.persist.UserRepos;
import com.example.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepos userRepos;

	@Override
	public List<User> JPA_findAll() {
		return userRepos.findAll();
	}

}
