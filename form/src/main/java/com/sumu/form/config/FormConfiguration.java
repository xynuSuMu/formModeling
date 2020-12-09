package com.sumu.form.config;

import com.sumu.form.engine.FormEngine;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-09 15:10
 */
public abstract class FormConfiguration {

    protected String jdbcDriver;
    protected String jdbcUrl;
    protected String jdbcUsername;
    protected String jdbcPassword;


    public abstract void builder();

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }
}
