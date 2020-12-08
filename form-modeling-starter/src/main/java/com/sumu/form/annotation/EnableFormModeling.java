package com.sumu.form.annotation;

import com.sumu.form.config.DBConfig;
import com.sumu.form.config.FormModelingConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:44
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({FormModelingConfig.class, DBConfig.class})
public @interface EnableFormModeling {
}
