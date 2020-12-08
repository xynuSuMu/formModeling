package com.sumu.form;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 14:25
 */
public class FormConfiguration implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public FormConfiguration() {
        System.out.println("====");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
