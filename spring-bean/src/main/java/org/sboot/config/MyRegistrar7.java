package org.sboot.config;

import org.sboot.service.impl.BookServiceImpl2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * BeanDefinition的方式注册bean
 * @author qlk
 */
public class MyRegistrar7 implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        BeanDefinition beanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition(BookServiceImpl2.class).getBeanDefinition();

        registry.registerBeanDefinition("bookService", beanDefinition);
    }
}
