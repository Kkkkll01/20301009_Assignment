package com.example.order.controller;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.result.HttpResult;
import com.example.order.entity.TransportOrder;
import com.example.order.service.TransportOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * (TransportOrder)表控制层
 *
 * @author Lumos
 * @date 2023-05-22
 */
@RestController
@RequestMapping("transportOrder")
public class TransportOrderController {
    /**
     * 服务对象
     */
    @Resource
    private TransportOrderService transportOrderService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param transportOrder 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public HttpResult selectAll(Page<TransportOrder> page, TransportOrder transportOrder, String orderNumberLike) {
        QueryWrapper<TransportOrder> wrapper = new QueryWrapper<>(transportOrder);
        if (orderNumberLike != null) {
            wrapper.like("order_number", orderNumberLike);
        }
        return HttpResult.success(this.transportOrderService.page(page, wrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping
    public HttpResult selectOne(@RequestParam Long id) {
        return HttpResult.success(this.transportOrderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param transportOrder 实体对象
     * @return 新增结果
     */
    @PostMapping
    public HttpResult insert(@RequestBody TransportOrder transportOrder) {

        transportOrder.setOrderNumber(DateUtil.format(new Date(), "yyyyMMdd") + new Random().nextInt(100000));
        transportOrder.setCreateTime(new Date());
        transportOrder.setStatus("已发货");
        return HttpResult.success(this.transportOrderService.save(transportOrder));
    }

    /**
     * 修改数据
     *
     * @param transportOrder 实体对象
     * @return 修改结果
     */
    @PutMapping
    public HttpResult update(@RequestBody TransportOrder transportOrder) {
        return HttpResult.success(this.transportOrderService.updateById(transportOrder));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    public HttpResult delete(@RequestParam("id") Long id) {
        return HttpResult.success(this.transportOrderService.removeById(id));
    }
}
