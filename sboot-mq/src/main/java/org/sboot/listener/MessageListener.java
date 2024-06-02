package org.sboot.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author qlk
 * <p>
 * 消息监听器,不需要手动处理消息
 */
@Component
public class MessageListener {

    @JmsListener(destination = "order.queue.id")
    @SendTo("order.other.queue.id")  // 处理方法的返回值转发到另一个destination
    public String receive(String id) {
        System.out.println("已完成短信发送业务,id: " + id);
        return "new:" + id;
    }

}
