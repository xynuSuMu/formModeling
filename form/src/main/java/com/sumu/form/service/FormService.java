package com.sumu.form.service;

import com.sumu.form.annotation.MethodDesc;
import com.sumu.form.annotation.MethodParam;
import com.sumu.form.bean.domin.FormRuleDo;
import com.sumu.form.bean.modal.FieldModal;
import com.sumu.form.bean.vo.FormTableView;

import java.util.List;
import java.util.Map;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-29 20:23
 */
public interface FormService {

    @MethodDesc(desc = "删除表单")
    @MethodParam(desc = {
            "tableName:表单名称"
    })
    Boolean deleteFormTable(
            String tableName
    );

    @MethodDesc(desc = "创建表单")
    @MethodParam(desc = {
            "formTableView:表单信息：包含表单名称，表单字段，组件字段信息"
    })
    Boolean createFormTable(
            FormTableView formTableView
    );

    @MethodDesc(desc = "获取表单的字段信息-仅包含用户自定义字段，不包含系统字段")
    @MethodParam(desc = {
            "tableName:表单名称"
    })
    List<FieldModal> getFieldModal(
            String tableName
    );


    @MethodDesc(desc = "保存表单样式")
    @MethodParam(desc = {
            "tableName:表单名称",
            "formName:表单样式名称",
            "formDesc:表单样式描述",
            "html:表单样式Html",
            "formRuleDos:表单样式中字段规则：是否可编辑，是否必填",
    })
    Boolean saveFormTableStyle(
            String tableName,
            String formName,
            String formDesc,
            String html,
            List<FormRuleDo> formRuleDos);

    @MethodDesc(desc = "提交表单")
    @MethodParam(desc = {
            "tableName:表单名称",
            "formName:表单样式名称",
            "sysServiceId:业务ID，该ID用于查询表单唯一信息，",
            "fieldValue:表单中字段值，表单样式中，必填字段不能为空，只读字段不会进行存储",
    })
    Boolean submitFormTable(
            String tableName,
            String formName,
            String sysServiceId,
            Map<String, Object> fieldValue
    );

    @MethodDesc(desc = "获取表单中字段值")
    @MethodParam(desc = {
            "tableName:表单名称",
            "formName:表单样式名称",
            "sysServiceId:业务ID，该ID用于查询表单唯一信息，",
    })
    Map<String, Object> getFormFieldValue(
            String tableName,
            String formName,
            String sysServiceId
    );


}
