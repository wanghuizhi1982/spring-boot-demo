package com.example.persist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepos extends JpaRepository<User, Long> {
	 /**
     * 通过用户名相等查询
     *
     * @param name 用户名
     * @return
     */
    List<User> findByName(String name);
    /**
     * 通过名字like查询
     *
     * @param name 用户名
     * @return
     */
    List<User> findByNameLike(String name);

}
