package com.sumu.form.config;

import com.sumu.form.FormManager;
import com.sumu.form.properties.FormModelingProperties;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:44
 */
@ComponentScan({"com.sumu.form.service"})
@AutoConfigureAfter(name = {"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"})
@EnableConfigurationProperties({FormModelingProperties.class})
public class FormModelingConfig {

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    @ConditionalOnMissingBean(FormManager.class)
    public FormManager formManager(DataSource dataSource, FormModelingProperties formModelingProperties) {
        SpringFormConfiguration springFormConfiguration = new SpringFormConfiguration(dataSource);
        springFormConfiguration.setInitSystemTable(formModelingProperties.getInitSystemTable());
        springFormConfiguration.setCheckSystemTable(formModelingProperties.getCheckSystemTable());
        springFormConfiguration.setUpdateSystemTable(formModelingProperties.getUpdateSystemTable());


        return new FormManager(springFormConfiguration);
    }

}
