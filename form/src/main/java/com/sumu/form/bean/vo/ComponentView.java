package com.sumu.form.bean.vo;

import com.sumu.form.annotation.FieldDesc;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:39
 */
public class ComponentView {

    @FieldDesc(desc = "组件key")
    private String key;

    @FieldDesc(desc = "组件值")
    private String value;


    @FieldDesc(desc = "表单排序👌")
    private int sort;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
