package com.sumu.form.entity.data;

import com.sumu.form.mapper.FormMapper;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-09 14:20
 */
public class DataManager {

    private static FormMapper formMapper;

    public static FormMapper getFormMapper() {
        return formMapper;
    }

    public static void setFormMapper(FormMapper formMapper) {
        DataManager.formMapper = formMapper;
    }
}
