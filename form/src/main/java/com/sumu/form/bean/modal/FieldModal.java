package com.sumu.form.bean.modal;

import com.sumu.form.annotation.FieldDesc;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 17:06
 */
public class FieldModal {
    //字段key
    @FieldDesc(desc = "字段key")
    private String fieldKey;

    //字段描述
    @FieldDesc(desc = "字段描述")
    private String fieldName;

    //前端字段类型
    @FieldDesc(desc = "前端字段类型")
    private String fieldType;

    //是否必填
    @FieldDesc(desc = "是否必填")
    private Boolean required;

    //默认值
    @FieldDesc(desc = "默认值")
    private String scopeValue;

    //组件
    @FieldDesc(desc = "组件")
    private List<ComponentModal> componentModals;

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public void setScopeValue(String scopeValue) {
        this.scopeValue = scopeValue;
    }

    public List<ComponentModal> getComponentModals() {
        return componentModals;
    }

    public void setComponentModals(List<ComponentModal> componentModals) {
        this.componentModals = componentModals;
    }
}
