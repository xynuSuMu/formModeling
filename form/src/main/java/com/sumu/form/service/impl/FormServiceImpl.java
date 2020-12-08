package com.sumu.form.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sumu.form.bean.domin.AttributeDo;
import com.sumu.form.bean.domin.ComponentDo;
import com.sumu.form.bean.domin.FormDo;
import com.sumu.form.bean.domin.FormRuleDo;
import com.sumu.form.bean.modal.FieldModal;
import com.sumu.form.bean.vo.ComponentView;
import com.sumu.form.bean.vo.FieldView;
import com.sumu.form.bean.vo.FormTableView;
import com.sumu.form.enume.FieldType;
import com.sumu.form.mapper.FormMapper;
import com.sumu.form.service.FormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-29 20:24
 */
@Service
public class FormServiceImpl implements FormService {

//    @Autowired
    private FormMapper formMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Boolean deleteFormTable(String tableName) {
        formMapper.dropTable(tableName);
        return true;
    }

    @Override
    public Boolean createFormTable(FormTableView formTableView) {
        FormTableView param = formTableView;
        //创建
        String table = formMapper.isExistForm(param.getTableName());
        if (table == null) {
            List<FormDo> cloums = new ArrayList<>();
            List<AttributeDo> list = new ArrayList<>();
            List<ComponentDo> componentDos = new ArrayList<>();
            for (FieldView fieldView : param.getFieldViews()) {
                FormDo formDo = new FormDo();
                formDo.setFieldKey(fieldView.getFieldKey());
                formDo.setFieldName(fieldView.getFieldName());
                //字段类型
                FieldType.Relation relation = FieldType.Relation.getRelation(fieldView.getFieldType());
                formDo.setFieldType(relation.getBack());
                //小数点类型
                if (relation.getPoint()) {
                    formDo.setLength(fieldView.getLength() + "," + fieldView.getPoint());
                } else {
                    formDo.setLength(fieldView.getLength());
                }
                //组件类型：下拉框，复选框，单选框
                if (relation.getComponent()) {
                    List<ComponentView> componentViews = fieldView.getComponentViews();
                    for (ComponentView componentView : componentViews) {
                        ComponentDo componentDo = new ComponentDo();
                        componentDo.setTableName(param.getTableName());
                        componentDo.setFieldKey(fieldView.getFieldKey());
                        componentDo.setKey(componentView.getKey());
                        componentDo.setValue(componentView.getValue());
                        componentDo.setSort(componentView.getSort());
                        componentDos.add(componentDo);
                    }
                }
                //全部允许为true
                formDo.setNull(true);
                cloums.add(formDo);
                //=========保存字段信息========
                AttributeDo attributeDo = new AttributeDo(param.getTableName(),
                        fieldView.getFieldKey(),
                        fieldView.getFieldName(),
                        fieldView.getFieldType(),
                        fieldView.getScopeValue(),
                        fieldView.getRequired());
                list.add(attributeDo);
            }
            //表单信息
            formMapper.insertFormInfo(param.getTableName(), param.getTableDesc());
            //字段信息
            formMapper.insertAttribute(list);
            //组件信息
            formMapper.insertComponent(componentDos);
            //创建物理表单
            formMapper.createForm(param.getTableName(), cloums, param.getTableDesc());
            return true;
        } else {
            logger.info("表单存在，请删除");
            return false;
        }

    }

    @Override
    public List<FieldModal> getFieldModal(String tableName) {
        List<FieldModal> list = formMapper.getFormFieldInfo(tableName);
        for (FieldModal fieldModal : list) {
            FieldType.Relation relation = FieldType.Relation.getRelation(fieldModal.getFieldType());
            if (relation.getComponent()) {
                fieldModal.setComponentModals(
                        formMapper.getFieldComponentInfo(tableName,
                                fieldModal.getFieldKey()));
            }
        }
        logger.info(JSONObject.toJSONString(list));
        return list;
    }

    @Override
    public Boolean saveFormTableStyle(String tableName, String formName, String formDesc, String html, List<FormRuleDo> formRuleDos) {

        //表单字段属性
        formMapper.insertFormTableStyle(formRuleDos);
        //表单样式
        formMapper.insertFormTable(formName, formDesc, tableName, html);

        return true;
    }

    @Override
    public Boolean submitFormTable(String tableName,
                                   String formName,
                                   String sysServiceId,
                                   Map<String, Object> fieldValue) {
        Map<String, Object> columnMap = new HashMap<>();
        //校验该表单
        List<FormRuleDo> formRuleDos = formMapper.getFormRule(formName);
        System.out.println(JSONObject.toJSONString(formRuleDos));
        for (FormRuleDo formRuleDo : formRuleDos) {
            Boolean isRequired = formRuleDo.getRequired();
            Boolean edit = formRuleDo.getEdit();
            //必填写
            if (isRequired && !fieldValue.containsKey(formRuleDo.getFieldKey())) {
                System.out.println(formRuleDo.getFieldKey() + "必填!");
                throw new RuntimeException(formRuleDo.getFieldKey() + "必填!");
            }
            //可编辑，不可编辑的数据直接忽略
            if (edit) {
                columnMap.put(formRuleDo.getFieldKey(), fieldValue.get(formRuleDo.getFieldKey()));
            }
        }
        columnMap.put("sys_service_id", sysServiceId);
        //插入数据
        formMapper.insertForm(tableName, columnMap);

        return true;
    }

    @Override
    public Map<String, Object> getFormFieldValue(String tableName, String formName, String sysServiceId) {
        Map<String, Object> map = formMapper.getFieldValue(tableName, sysServiceId);
        System.out.println(map.toString());
        //该表单保存的字段
        List<FormRuleDo> formRuleDos = formMapper.getFormRule(formName);
        Map<String, Object> mapRes = new HashMap<>();
        for (FormRuleDo formRuleDo : formRuleDos) {
            if (map.containsKey(formRuleDo.getFieldKey())) {
                mapRes.put(formRuleDo.getFieldKey(), map.get(formRuleDo.getFieldKey()));
            }
        }
        return mapRes;
    }
}
