package com.sumu.form.bean.domin;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-28 22:43
 */
public class FormRuleDo {
    //      `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
//  `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
//            `html_id` int(11) NOT NULL  COMMENT '表单样式ID',
//            `field_key` varchar(100) NOT NULL DEFAULT '' COMMENT '字段名称',
//            `required` tinyint(1) DEFAULT NULL COMMENT '是否必填',
//            `edit` tinyint(1) DEFAULT NULL COMMENT '是否可编辑',
    private String tableName;
    private String htmlName;
    private String fieldKey;
    private Boolean required;
    private Boolean edit;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public String getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean getEdit() {
        return edit;
    }

    public void setEdit(Boolean edit) {
        this.edit = edit;
    }
}
