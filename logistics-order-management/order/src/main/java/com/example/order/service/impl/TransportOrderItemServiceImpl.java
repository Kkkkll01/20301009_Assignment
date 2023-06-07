package com.example.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.dao.TransportOrderItemDao;
import com.example.order.entity.TransportOrderItem;
import com.example.order.service.TransportOrderItemService;
import org.springframework.stereotype.Service;

/**
 * (TransportOrderItem)表服务实现类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Service("transportOrderItemService")
public class TransportOrderItemServiceImpl extends ServiceImpl<TransportOrderItemDao, TransportOrderItem> implements TransportOrderItemService {

}
