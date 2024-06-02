package org.sboot.service.impl;

import org.sboot.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qlk
 */
//@Service
public class MessageServiceImpl implements MessageService {

    // 消息队列模拟
    private List<String> msgList = new ArrayList<>();

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已经纳入处理队列,id: " + id);
        msgList.add(id);
    }

    @Override
    public String doMessage() {
        String id = msgList.remove(0);
        System.out.println("已完成短信发送业务,id: " + id);
        return id;
    }
}
