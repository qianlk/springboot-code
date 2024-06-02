package org.sboot.app;

import org.sboot.config.SpringConfig33;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author qlk
 */
public class App33 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig33.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        SpringConfig33 springConfig33 = ctx.getBean("springConfig33", SpringConfig33.class);
        // 直接方法调用
        // proxyBeanMethods属性为false,不是单例
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
        System.out.println(springConfig33.cat());
    }
}
