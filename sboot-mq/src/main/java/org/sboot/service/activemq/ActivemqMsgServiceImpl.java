package org.sboot.service.activemq;

import org.sboot.service.MessageService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qlk
 */

@Service
public class ActivemqMsgServiceImpl implements MessageService {

    @Resource
    private JmsMessagingTemplate messagingTemplate;

    @Override
    public void sendMessage(String id) {
        System.out.println("待发送短信的订单已经纳入处理队列,id: " + id);
//        messagingTemplate.convertAndSend(id);
        messagingTemplate.convertAndSend("order.queue.id", id);
    }

    @Override
    public String doMessage() {
//        String id = messagingTemplate.receiveAndConvert(String.class);
        String id = messagingTemplate.receiveAndConvert("order.queue.id", String.class);
        System.out.println("已完成短信发送业务,id: " + id);
        return id;
    }
}
