package com.sumu.form.config;

import com.sumu.form.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-30 16:52
 */
@Configuration
@Component
public class FormConfiguration {

    @Autowired
    private FormService formService;

    @Bean
    public FormService formService() {
        return formService;
    }
}
