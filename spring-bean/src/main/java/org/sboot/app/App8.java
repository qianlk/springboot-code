package org.sboot.app;

import org.sboot.config.SpringConfig8;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 使用 ImportSelector
 *
 * @author qlk
 */
public class App8 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig8.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
