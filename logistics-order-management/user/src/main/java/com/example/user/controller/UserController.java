package com.example.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.result.HttpResult;
import com.example.common.util.JwtUtil;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author Lumos
 * @date 2023-05-22
 */
@RestController
@RequestMapping("usr")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    /**
     * 登录
     *
     * @param user 查询实体
     * @return 所有数据
     */
    @PostMapping("login")
    public HttpResult login(@RequestBody User user, HttpServletResponse response) {
        User u = this.userService.login(user);
        Map<Object, Object> result = new HashMap<>();
        result.put("id", u.getId());
        result.put("username", u.getUsername());
        result.put("role", u.getRole());
        result.put("token", JwtUtil.create(u.getRole()));
        return HttpResult.success(result);
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public HttpResult selectAll(Page<User> page, User user) {
        return HttpResult.success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping
    public HttpResult selectOne(@RequestParam Long id) {
        return HttpResult.success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public HttpResult insert(@RequestBody User user) {
        return HttpResult.success(this.userService.save(user));
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping
    public HttpResult update(@RequestBody User user) {
        return HttpResult.success(this.userService.updateById(user));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    public HttpResult delete(@RequestParam("id") Long id) {
        return HttpResult.success(this.userService.removeById(id));
    }
}
