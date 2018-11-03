package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserInfo;
import com.example.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	IUserService userService;

	@Autowired
	private StringRedisTemplate template;
	
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	@RequestMapping("index")
	public String Index() {
		return "hello world";
	}
	@ApiOperation(value="查找用户详细信息", notes="根据find的id来获取用户详细信息")
	@RequestMapping("find")
	public Object find() {
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setName("张小三");
		user.setAge(12);
		return user;
	}
	@ApiOperation(value="查找所有用户详细信息", notes="根据findAll的id来获取用户详细信息")
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
