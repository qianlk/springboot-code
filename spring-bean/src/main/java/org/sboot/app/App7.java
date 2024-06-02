package org.sboot.app;

import org.sboot.config.SpringConfig7;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * 使用 ImportSelector
 *
 * @author qlk
 */
public class App7 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig7.class);

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
