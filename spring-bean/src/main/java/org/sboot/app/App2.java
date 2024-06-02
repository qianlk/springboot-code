package org.sboot.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * 注解方式注入bean
 * @author qlk
 */
public class App2 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
