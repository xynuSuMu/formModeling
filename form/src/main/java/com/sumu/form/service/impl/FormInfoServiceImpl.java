package com.sumu.form.service.impl;

import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;
import com.sumu.form.context.Context;
import com.sumu.form.entity.data.FormInfoDataManager;
import com.sumu.form.service.FormInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:30
 */
@Service
public class FormInfoServiceImpl implements FormInfoService {
    @Override
    public List<TableInfoDo> getTableInfo() {
        return Context.getManager(FormInfoDataManager.class)
                .getTableInfo();

    }

    @Override
    public List<BriefTableStyleDo> getBriefTableStyle(String tableName) {
        return Context.getManager(FormInfoDataManager.class)
                .getBriefTableStyle(tableName);
    }

    @Override
    public String getTableStyleHtml(int id) {
        return Context.getManager(FormInfoDataManager.class).getTableStyleHtml(id);
    }
}
