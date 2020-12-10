package com.sumu.form.entity.data;

import com.sumu.form.config.FormConfigurationImpl;
import com.sumu.form.context.Context;
import com.sumu.form.entity.AbstractManager;
import org.apache.ibatis.session.SqlSession;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 09:03
 */
public class AbstractDataManager extends AbstractManager {

    public AbstractDataManager(FormConfigurationImpl formConfiguration) {
        super(formConfiguration);
    }


}
