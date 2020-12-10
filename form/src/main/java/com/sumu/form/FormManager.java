package com.sumu.form;

import com.sumu.form.config.SpringFormConfiguration;
import com.sumu.form.engine.FormEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 10:56
 */
public class FormManager {

    private Logger LOG = LoggerFactory.getLogger(FormManager.class);

    private SpringFormConfiguration springFormConfiguration;

    public FormManager(SpringFormConfiguration springFormConfiguration) {
        this.springFormConfiguration = springFormConfiguration;

    }

    public void init() {
        LOG.info("Form Modeling Init...");
        springFormConfiguration.builder();
        LOG.info("Form Modeling Start");
    }

    public void destroy() {
        LOG.info("Form Modeling Stop");
    }
}
