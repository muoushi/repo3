package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

/**
 * @author ：X H
 * @version :
 * @date ：Created in 2020/3/5 13:36
 * @description：
 * @modified By：
 */

public interface IUserDao {
    //查找所有
    List<User> findAll();

    //保存对象
    void saveUser(User user);

    //更新对象
    void updateUser(User user);

    //删除对象
    void deleteUser(Integer userId);

    //根据ID查找对象
    User findById(Integer userId);

    //根据名字查找对象
    List<User> findByUserName(String userName);

    //查询总记录数
    Integer findTotal();

    //根据QueryVo的条件查询用户
    User findByQueryVo(QueryVo vo);
}
