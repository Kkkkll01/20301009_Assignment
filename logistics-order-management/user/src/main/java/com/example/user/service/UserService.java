package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.user.entity.User;

/**
 * (User)表服务接口
 *
 * @author Lumos
 * @date 2023-05-22
 */
public interface UserService extends IService<User> {


    User login(User user);
}
