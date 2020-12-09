package com.sumu.form;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.sumu.form.mapper")
public class FormApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormApplication.class, args);
    }

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    @ConditionalOnMissingBean(FormManager.class)
    public FormManager formManager(DataSource dataSource) {
        return new FormManager(dataSource);
    }


}
