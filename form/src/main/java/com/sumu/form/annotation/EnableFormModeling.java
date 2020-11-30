package com.sumu.form.annotation;

import com.sumu.form.config.FormConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-30 16:40
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FormConfiguration.class)
public @interface EnableFormModeling {

}
