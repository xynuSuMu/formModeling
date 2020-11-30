package com.sumu.form.bean.vo;

import com.sumu.form.annotation.FieldDesc;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:16
 */
public class FieldView {

    //字段key
    @FieldDesc(desc = "字段key")
    private String fieldKey;

    //字段描述
    @FieldDesc(desc = "字段描述")
    private String fieldName;

    //前端字段类型
    @FieldDesc(desc = "前端字段类型")
    private String fieldType;

    //字段长度
    @FieldDesc(desc = "字段长度")
    private String length;

    //小数点位数
    @FieldDesc(desc = "小数点位数，针对金额，浮点数")
    private String point;

    //是否必填
    @FieldDesc(desc = "是否必填")
    private Boolean required;

    //默认值
    @FieldDesc(desc = "字段默认值")
    private String scopeValue;

    //组件
    @FieldDesc(desc = "组件:针对radio,select,checkbox")
    private List<ComponentView> componentViews;

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
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

    public List<ComponentView> getComponentViews() {
        return componentViews;
    }

    public void setComponentViews(List<ComponentView> componentViews) {
        this.componentViews = componentViews;
    }

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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
