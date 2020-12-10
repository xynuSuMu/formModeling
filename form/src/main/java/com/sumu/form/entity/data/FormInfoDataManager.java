package com.sumu.form.entity.data;

import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;
import com.sumu.form.config.FormConfigurationImpl;
import com.sumu.form.context.Context;
import com.sumu.form.mapper.FormInfoMapper;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:33
 */
public class FormInfoDataManager extends AbstractDataManager {

    FormInfoMapper formInfoMapper;

    public FormInfoDataManager(FormConfigurationImpl formConfiguration,
                               FormInfoMapper formInfoMapper
    ) {
        super(formConfiguration);
        this.formInfoMapper = formInfoMapper;
    }

    public List<TableInfoDo> getTableInfo() {
        return formInfoMapper.getTableInfo();
    }


    public List<BriefTableStyleDo> getBriefTableStyle(String tableName) {
        return formInfoMapper.getBriefTableStyle(tableName);
    }

    public String getTableStyleHtml(int id) {
        try {
            return formInfoMapper.getTableStyleHtml(id);
        } finally {
            Context.getSqlSession().clearCache();
        }
    }
}
