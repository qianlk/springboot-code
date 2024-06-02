package org.sboot.config;

import org.sboot.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * proxyBeanMethods属性
 * 保证bean的唯一性
 *
 * @author qlk
 */
@Configuration(proxyBeanMethods = false)
public class SpringConfig33 {

    @Bean
    public Cat cat() {
        return new Cat();
    }

}
