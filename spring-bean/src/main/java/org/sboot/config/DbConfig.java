package org.sboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置第三方开发的bean
 * @author qlk
 */
@Configuration
public class DbConfig {

    @Bean
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
