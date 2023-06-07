package com.example.order.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.result.HttpResult;
import com.example.order.entity.TransportOrderItem;
import com.example.order.service.TransportOrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (TransportOrderItem)表控制层
 *
 * @author Lumos
 * @date 2023-05-22
 */
@RestController
@RequestMapping("transportOrderItem")
public class TransportOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private TransportOrderItemService transportOrderItemService;

    /**
     * 分页查询所有数据
     *
     * @param page               分页对象
     * @param transportOrderItem 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public HttpResult selectAll(Page<TransportOrderItem> page, TransportOrderItem transportOrderItem) {
        return HttpResult.success(this.transportOrderItemService.page(page, new QueryWrapper<>(transportOrderItem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping
    public HttpResult selectOne(@RequestParam Long id) {
        return HttpResult.success(this.transportOrderItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param transportOrderItem 实体对象
     * @return 新增结果
     */
    @PostMapping
    public HttpResult insert(@RequestBody TransportOrderItem transportOrderItem) {
        transportOrderItem.setUpdateTime(new Date());
        return HttpResult.success(this.transportOrderItemService.save(transportOrderItem));
    }

    /**
     * 修改数据
     *
     * @param transportOrderItem 实体对象
     * @return 修改结果
     */
    @PutMapping
    public HttpResult update(@RequestBody TransportOrderItem transportOrderItem) {
        return HttpResult.success(this.transportOrderItemService.updateById(transportOrderItem));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    public HttpResult delete(@RequestParam("id") Long id) {
        return HttpResult.success(this.transportOrderItemService.removeById(id));
    }
}
