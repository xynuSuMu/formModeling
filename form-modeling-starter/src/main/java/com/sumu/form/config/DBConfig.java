package com.sumu.form.config;

import com.sumu.form.FormConfiguration;
import com.sumu.form.FormManager;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:44
 */
@AutoConfigureAfter(name = {"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"})
public class DBConfig {


    @Bean
    @ConditionalOnMissingBean(FormConfiguration.class)
    public FormConfiguration formModelingConfig(DataSource dataSource) throws SQLException {
        System.out.println(dataSource.getConnection().getAutoCommit());
        return new FormConfiguration();
    }
}
