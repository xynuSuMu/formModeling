package com.sumu.form.service;

import com.sumu.form.annotation.MethodDesc;
import com.sumu.form.annotation.MethodParam;
import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:30
 */
public interface FormInfoService {

    @MethodDesc(desc = "获取用户自定义所有表单")
    @MethodParam(desc = {

    })
    List<TableInfoDo> getTableInfo();

    @MethodDesc(desc = "自定义表单样式集合")
    @MethodParam(desc = {
            "tableName:表单Key"
    })
    List<BriefTableStyleDo> getBriefTableStyle(String tableName);

    @MethodDesc(desc = "表单样式Ht")
    @MethodParam(desc = {
            "id:样式ID"
    })
    String getTableStyleHtml(int id);

}
