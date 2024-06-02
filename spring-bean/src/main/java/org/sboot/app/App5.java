package org.sboot.app;

import org.sboot.bean.Mouse;
import org.sboot.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Objects;

/**
 * 容器启动后注册
 *
 * @author qlk
 */
public class App5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);


        // 容器上下文已经初始化完毕,手工加载bean
        // Mouse类已经注入,更换命名
        ctx.registerBean("mouse", Mouse.class);
        ctx.registerBean("mouse", Mouse.class);
        ctx.registerBean("mouse", Mouse.class);
        System.out.println(ctx.getBean("mouse"));
        System.out.println(Objects.equals(ctx.getBean("mouse"), ctx.getBean("jerry")));

        // Mouse类已经注入
//        ctx.register(Mouse.class);
        System.out.println("===");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
