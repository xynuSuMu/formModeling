package com.sumu.form.service.impl;

import com.sumu.form.bean.domin.FormRuleDo;
import com.sumu.form.bean.modal.FieldModal;
import com.sumu.form.bean.vo.FormTableView;
import com.sumu.form.entity.data.DataManager;
import com.sumu.form.service.FormService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-29 20:24
 */
@Service
public class FormServiceImpl implements FormService {


    @Override
    public Boolean deleteFormTable(String tableName) {
        return DataManager.deleteFormTable(tableName);
    }

    @Override
    public Boolean createFormTable(FormTableView formTableView) {
        return DataManager.createFormTable(formTableView);

    }

    @Override
    public List<FieldModal> getFieldModal(String tableName) {
        return DataManager.getFieldModal(tableName);
    }

    @Override
    public Boolean saveFormTableStyle(String tableName, String formName, String formDesc, String html, List<FormRuleDo> formRuleDos) {

        return DataManager.saveFormTableStyle(tableName, formName, formDesc, html, formRuleDos);
    }

    @Override
    public Boolean submitFormTable(String tableName,
                                   String formName,
                                   String sysServiceId,
                                   Map<String, Object> fieldValue) {
        return DataManager.submitFormTable(tableName, formName, sysServiceId, fieldValue);
    }

    @Override
    public Map<String, Object> getFormFieldValue(String tableName, String formName, String sysServiceId) {
        return DataManager.getFormFieldValue(tableName, formName, sysServiceId);
    }
}
