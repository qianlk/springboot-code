package org.sboot.app;

import org.sboot.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author qlk
 */
public class App4 {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig4.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

    }
}
