package com.example.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.order.dao.TransportOrderDao;
import com.example.order.entity.TransportOrder;
import com.example.order.service.TransportOrderService;
import org.springframework.stereotype.Service;

/**
 * (TransportOrder)表服务实现类
 *
 * @author Lumos
 * @date 2023-05-22
 */
@Service("transportOrderService")
public class TransportOrderServiceImpl extends ServiceImpl<TransportOrderDao, TransportOrder> implements TransportOrderService {

}
