package com.sumu.form.bean.domin.info;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:14
 */
public class TableInfoDo {
    private int id;
    private String tableName;
    private String tableDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
