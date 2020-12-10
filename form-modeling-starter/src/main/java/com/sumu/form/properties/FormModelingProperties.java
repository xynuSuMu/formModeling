package com.sumu.form.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 10:16
 */
@ConfigurationProperties("spring.form.modeling")
public class FormModelingProperties {
    private Boolean checkSystemTable;
    private Boolean updateSystemTable;

    private Boolean initSystemTable;

    public Boolean getCheckSystemTable() {
        return checkSystemTable;
    }

    public void setCheckSystemTable(Boolean checkSystemTable) {
        this.checkSystemTable = checkSystemTable;
    }

    public Boolean getUpdateSystemTable() {
        return updateSystemTable;
    }

    public void setUpdateSystemTable(Boolean updateSystemTable) {
        this.updateSystemTable = updateSystemTable;
    }

    public Boolean getInitSystemTable() {
        return initSystemTable;
    }

    public void setInitSystemTable(Boolean initSystemTable) {
        this.initSystemTable = initSystemTable;
    }
}
