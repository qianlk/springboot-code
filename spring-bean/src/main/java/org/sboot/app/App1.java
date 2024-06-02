package org.sboot.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * xml方式注入bean
 * @author qlk
 */
public class App1 {

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext1.xml");

//        System.out.println(ctx.getBean("cat"));

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
