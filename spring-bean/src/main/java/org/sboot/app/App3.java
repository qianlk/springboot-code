package org.sboot.app;

import org.sboot.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 注解方式注入bean
 *
 * @author qlk
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(ctx.getBean("dog1"));
        System.out.println(ctx.getBean("dog1"));
    }
}
