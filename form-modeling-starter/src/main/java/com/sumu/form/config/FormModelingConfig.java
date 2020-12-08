package com.sumu.form.config;

import com.sumu.form.FormManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:44
 */
@ComponentScan({"com.sumu.form"})
public class FormModelingConfig {

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    @ConditionalOnMissingBean(FormManager.class)
    public FormManager formManager() {
        return new FormManager();
    }

}
