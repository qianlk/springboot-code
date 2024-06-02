package org.sboot.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author qlk
 */
public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        return new Dog();
    }

    @Override
    public Class<?> getObjectType() {
        return Dog.class;
    }

    /**
     * 默认单例
     * @return true(默认):单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
