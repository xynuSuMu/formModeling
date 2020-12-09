package com.sumu.form.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sql.DataSource;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 14:25
 */
public class SpringFormConfiguration extends FormConfigurationImpl implements ApplicationContextAware {

    public SpringFormConfiguration(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
