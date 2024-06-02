package org.sboot.service.impl;

import org.junit.jupiter.api.Test;
import org.sboot.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author qlk
 */
@SpringBootTest
class SendMailServiceImplTest {

    @Autowired
    private SendMailService sendMailService;

    @Test
    void testSendMail() {
        sendMailService.sendMail();
    }

}