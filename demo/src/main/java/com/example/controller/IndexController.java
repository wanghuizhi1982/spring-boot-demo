package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserInfo;
import com.example.service.IUserService;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	IUserService userService;

	@Autowired
	private StringRedisTemplate template;

	@RequestMapping("index")
	public String Index() {
		return "hello world";
	}

	@RequestMapping("find")
	public Object find() {
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("张小三");
		user.setAge(12);
		return user;
	}

	@RequestMapping("findAll")
	public Object findAll() {

		if (!template.hasKey("shabao")) {
			template.opsForValue().append("shabao", "我是傻宝");
			System.out.println("使用redis缓存保存数据成功存在");
		} else {
			template.delete("shabao");
			System.out.println("key存在");
		}
		return userService.JPA_findAll();
	}
}
