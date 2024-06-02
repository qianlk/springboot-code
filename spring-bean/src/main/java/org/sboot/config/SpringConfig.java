package org.sboot.config;

import org.sboot.bean.Dog;
import org.sboot.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qlk
 */
@ComponentScan({"org.sboot.bean", "org.sboot.config"})
public class SpringConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public DogFactoryBean dog1() {
        return new DogFactoryBean();
    }
}
