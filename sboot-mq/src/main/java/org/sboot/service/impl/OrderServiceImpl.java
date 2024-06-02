package org.sboot.service.impl;

import org.sboot.service.MessageService;
import org.sboot.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qlk
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private MessageService messageService;


    @Override
    public void order(String id) {
        // 处理各种服务调用,以及业务
        System.out.println("订单处理开始");
        messageService.sendMessage(id);

        System.out.println("订单处理结束");

        System.out.println();

    }
}
