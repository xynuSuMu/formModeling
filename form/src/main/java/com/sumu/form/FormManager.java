package com.sumu.form;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:56
 */
public class FormManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    public FormManager() {
        System.out.println("加载FormManager========");
    }

    public void init() {
        System.out.println("初始化");
    }

    public void destroy() {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
