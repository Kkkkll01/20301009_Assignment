package com.example.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.exception.CommonException;
import com.example.common.result.ResultCodeEnum;
import com.example.user.dao.UserDao;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User login(User user) {
        User result = baseMapper.selectOne(
                new QueryWrapper<>(User.builder().account(user.getAccount()).password(user.getPassword()).build()));
        if (result == null) {
            throw new CommonException(ResultCodeEnum.USER_NOT_FOUND);
        }
        return result;
    }
}
