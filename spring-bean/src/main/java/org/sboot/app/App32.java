package org.sboot.app;

import org.sboot.config.SpringConfig32;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 注解方式注入bean
 *
 * @author qlk
 */
public class App32 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig32.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
