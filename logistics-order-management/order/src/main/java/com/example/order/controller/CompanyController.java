package com.example.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.result.HttpResult;
import com.example.order.entity.Company;
import com.example.order.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Company)表控制层
 *
 * @author Lumos
 * @date 2023-05-22
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param company 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public HttpResult selectAll(Page<Company> page, Company company) {
        return HttpResult.success(this.companyService.page(page, new QueryWrapper<>(company)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping
    public HttpResult selectOne(@RequestParam Long id) {
        return HttpResult.success(this.companyService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param company 实体对象
     * @return 新增结果
     */
    @PostMapping
    public HttpResult insert(@RequestBody Company company) {
        return HttpResult.success(this.companyService.save(company));
    }

    /**
     * 修改数据
     *
     * @param company 实体对象
     * @return 修改结果
     */
    @PutMapping
    public HttpResult update(@RequestBody Company company) {
        return HttpResult.success(this.companyService.updateById(company));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    public HttpResult delete(@RequestParam("id") Long id) {
        return HttpResult.success(this.companyService.removeById(id));
    }
}
