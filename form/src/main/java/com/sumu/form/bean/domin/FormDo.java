package com.sumu.form.bean.domin;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-26 09:47
 */
public class FormDo {
    //    字段key
    private String fieldKey;
    //    注释
    private String fieldName;
    //    字段类型
    private String fieldType;
    //    长度
    private String length;
    //    是否允许为null
    private Boolean isNull = true;

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

    public Boolean getNull() {
        return isNull;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }
}
