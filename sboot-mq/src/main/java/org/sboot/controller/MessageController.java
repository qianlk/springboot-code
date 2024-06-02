package org.sboot.controller;

import org.sboot.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qlk
 */
@RestController
@RequestMapping("/msg")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping
    public String doMessage() {
        String id = messageService.doMessage();
        return id;
    }
}
