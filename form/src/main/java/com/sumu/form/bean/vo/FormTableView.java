package com.sumu.form.bean.vo;

import com.sumu.form.annotation.FieldDesc;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:14
 */
public class FormTableView {


    @FieldDesc(desc = "表单名称")
    private String tableName;

    @FieldDesc(desc = "表单描述")
    private String tableDesc;

    @FieldDesc(desc = "表单字段")
    private List<FieldView> fieldViews;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public List<FieldView> getFieldViews() {
        return fieldViews;
    }

    public void setFieldViews(List<FieldView> fieldViews) {
        this.fieldViews = fieldViews;
    }
}
