package org.sboot.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 在容器初始化时,控制bean的加载过程
 *
 * @author qlk
 */
public class MyImportSelector6 implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        //
        System.out.println("===");
        System.out.println(metadata.getClassName());
        System.out.println(metadata.hasAnnotation("org.springframework.context.annotation.Configuration"));
        Map<String, Object> attrs = metadata.getAnnotationAttributes("org.springframework.context.annotation.Configuration");
        System.out.println(attrs);
        System.out.println("===");

        // 判断条件,决定是否加载bean
        boolean flag = metadata.hasAnnotation("org.springframework.context.annotation.Configuration");
        if (flag) {
            return new String[]{"org.sboot.bean.Dog"};
        }
        return new String[]{"org.sboot.bean.Cat"};
    }
}
