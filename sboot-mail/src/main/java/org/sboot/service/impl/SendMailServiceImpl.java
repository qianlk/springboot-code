package org.sboot.service.impl;

import org.sboot.service.SendMailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author qlk
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Resource
    private JavaMailSender javaMailSender;

    // 发送人
    private String from = "740942486@qq.com";
    // 接受人
    private String to = "3496744533@qq.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String context = "测试邮件正文内容";

    private String contextComplex = "测试邮件正文内容 " +
            "<a href='https://www.itcast.cn'>点开有惊喜</a>";

    @Override
    public void sendMail() {
        // 发送简单邮件
//        SimpleMailMessage message = new SimpleMailMessage();
//        // 显示默认邮箱
//        message.setFrom(from);
////        message.setFrom(from + "(小甜甜)");
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(context);
//        javaMailSender.send(message);


        // 发送复杂邮件
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            // true 允许多部件发送(带附件)
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(contextComplex, true);

            // 发送附件
            File attachment = new File("D:\\ProjectsRepo\\springboot-code\\springboot-code\\sboot-mail\\src\\main\\resources\\SpringBoot讲义.md");

            helper.addAttachment(attachment.getName(), attachment);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
