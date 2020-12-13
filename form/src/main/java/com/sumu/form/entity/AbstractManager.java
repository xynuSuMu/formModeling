package com.sumu.form.entity;

import com.sumu.form.config.FormConfigurationImpl;
import com.sumu.form.context.Context;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 09:01
 */
public abstract class AbstractManager {

    protected FormConfigurationImpl formConfiguration;

    public AbstractManager(FormConfigurationImpl formConfiguration) {
        this.formConfiguration = formConfiguration;
    }

    protected SqlSession getSqlSession() {
        return Context.getSqlSession();
    }




}
