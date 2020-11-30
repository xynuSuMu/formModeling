package com.sumu.form.bean.domin;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:34
 */
public class AttributeDo {
    private String tableName;
    private String fieldKey;
    private String fieldName;
    //类型 radio option check text
    private String fieldType;
    //默认值
    private String scopeValue;
    //是否必填
    private Boolean required;

    public AttributeDo(String tableName, String fieldKey, String fieldName, String fieldType, String scopeValue, Boolean required) {
        this.tableName = tableName;
        this.fieldKey = fieldKey;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.scopeValue = scopeValue;
        this.required = required;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
