package com.sumu.form.bean.domin;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:39
 */
public class ComponentDo {

    private String tableName;
    private String fieldKey;
    private String key;
    private String value;
    private int sort;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

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
