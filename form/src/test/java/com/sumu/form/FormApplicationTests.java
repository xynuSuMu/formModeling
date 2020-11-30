package com.sumu.form;


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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class FormApplicationTests {

    @Autowired
    private FormMapper formMapper;

    @Autowired
    private FormService formService;

    //删除表单
    @Test
    void deleteForm() {
        FormTableView param = param();
        formService.deleteFormTable(param.getTableName());
    }

    //创建表单
    @Test
    void createFormModeling() {
        FormTableView param = param();
        //创建
        String table = formMapper.isExistForm(param.getTableName());
        System.out.println(table);
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
        } else {
            System.out.println("表单存在，请删除");
        }
    }

    //获取表单信息
    @Test
    void getForm() {
        String tableName = param().getTableName();
        List<FieldModal> list = formMapper.getFormFieldInfo(tableName);
        for (FieldModal fieldModal : list) {
            FieldType.Relation relation = FieldType.Relation.getRelation(fieldModal.getFieldType());
            if (relation.getComponent()) {
                fieldModal.setComponentModals(
                        formMapper.getFieldComponentInfo(tableName,
                                fieldModal.getFieldKey()));
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }

    //表单布局
    @Test
    void addLayout() {
        String tableName = param().getTableName();
        StringBuffer sb = fromStyle();
        String formName = "Custom_Verification_Style_1";
        String formDesc = "核销流程ONE";
        //todo:¬表单字段属性
        List<FormRuleDo> formRuleDos = fromFieldRule();
        //表单字段属性
        formMapper.insertFormTableStyle(formRuleDos);
        //表单样式
        formMapper.insertFormTable(formName, formDesc, tableName, sb.toString());

    }

    //提交表单
    @Test
    void submitFormTable() {
        //表单样式ID
        String formID = "Custom_Verification_Style_1";
        String tableName = "form_custom_verification";
        //表单
        Map<String, Object> map = new HashMap<>();
        map.put("field_account", new BigDecimal(10.02));
        map.put("field_desc", "吃饭");
        map.put("field_invoice", "0");
        //
        Map<String, Object> columnMap = new HashMap<>();
        //校验该表单
        List<FormRuleDo> formRuleDos = formMapper.getFormRule(formID);
        System.out.println(JSONObject.toJSONString(formRuleDos));
        for (FormRuleDo formRuleDo : formRuleDos) {
            Boolean isRequired = formRuleDo.getRequired();
            Boolean edit = formRuleDo.getEdit();
            //必填写
            if (isRequired && !map.containsKey(formRuleDo.getFieldKey())) {
                System.out.println(formRuleDo.getFieldKey() + "必填!");
                throw new RuntimeException(formRuleDo.getFieldKey() + "必填!");
            }
            //可编辑，不可编辑的数据直接忽略
            if (edit) {
                columnMap.put(formRuleDo.getFieldKey(), map.get(formRuleDo.getFieldKey()));
            }
        }
        //插入数据
        formMapper.insertForm(tableName, columnMap);
    }

    //返回表单的值
    @Test
    void getFormContent() {
        //
        String formID = "Custom_Verification_Style_1";
        String tableName = "form_custom_verification";
        //sysField 用于区分数据
        Map<String, Object> map = formMapper.getFieldValue(tableName, "1");
        System.out.println(map.toString());
        //该表单保存的字段
        List<FormRuleDo> formRuleDos = formMapper.getFormRule(formID);
        Map<String, Object> mapRes = new HashMap<>();
        for (FormRuleDo formRuleDo : formRuleDos) {
            if (map.containsKey(formRuleDo.getFieldKey())) {
                mapRes.put(formRuleDo.getFieldKey(), map.get(formRuleDo.getFieldKey()));
            }
        }
    }

    //模拟前端参数
    public FormTableView param() {
        //=========表单========
        FormTableView formTableView = new FormTableView();
        String formKey = "form_custom_verification";
        String formDesc = "核销单";
        formTableView.setTableName(formKey);
        formTableView.setTableDesc(formDesc);
        //=======字段========
        List<FieldView> list = new ArrayList<>();
        formTableView.setFieldViews(list);
        // ========金额字段=========
        FieldView moneyField = new FieldView();
        moneyField.setFieldKey("field_account");
        moneyField.setFieldName("金额");
        moneyField.setFieldType("money");
        moneyField.setLength("10");
        moneyField.setPoint("8");//小数点
        moneyField.setRequired(true);//必填
        list.add(moneyField);
        //=========描述字段===========
        FieldView descField = new FieldView();
        descField.setFieldKey("field_desc");
        descField.setFieldName("理由");
        descField.setFieldType("text");
        descField.setLength("100");
        descField.setRequired(true);//必填
        descField.setScopeValue("我需要100元");//默认值
        list.add(descField);
        //=========发票 or 票据===========
        FieldView invoicefield = new FieldView();
        invoicefield.setFieldKey("field_invoice");
        invoicefield.setFieldName("是否存在发票");
        invoicefield.setFieldType("radio");
        invoicefield.setLength("50");
        invoicefield.setRequired(true);//必填
        //组件属性数据
        ComponentView yes = new ComponentView();
        yes.setKey("0");
        yes.setValue("是");
        yes.setSort(0);
        ComponentView no = new ComponentView();
        no.setKey("1");
        no.setValue("否");
        no.setSort(1);
        List<ComponentView> componentViews = new ArrayList<>();
        componentViews.add(yes);
        componentViews.add(no);
        invoicefield.setComponentViews(componentViews);
        list.add(invoicefield);
        return formTableView;
    }

    //模拟表单样式
    public StringBuffer fromStyle() {
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<meta charset=\"UTF - 8\">");
        sb.append("<title>Title</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<script>");
        sb.append("function hello() {");
        sb.append("console.log(\"1111xxxx\")");
        sb.append("}");
        sb.append("</script>");
        sb.append("<div>");
        sb.append("<label>金额</label>");
        sb.append("<input type=\"number\" disabled = true  id=\"field_account\" name=\"金额\">");
        sb.append("</div>");
        sb.append("<div>");
        sb.append("<label>理由</label>");
        sb.append("<input type=\"text\" id=\"field_desc\" name=\"金额\">");
        sb.append("</div>");
        sb.append("<div>");
        sb.append("<label>是否发票</label>");
        sb.append("<input type=\"radio\" name=\"field_invoice\" value=\"0\">是");
        sb.append("<input type=\"radio\" name=\"field_invoice\" value=\"1\">否");
        sb.append("</div>");
        sb.append("<button onclick=\"hello()\">提交</button>");
        sb.append(" </body>");
        sb.append("</html>");
        return sb;
    }

    //表单字段属性
    public List<FormRuleDo> fromFieldRule() {
        List<FormRuleDo> res = new ArrayList<>();
        String formKey = "form_custom_verification";
        FormRuleDo fieldAccount = new FormRuleDo();
        fieldAccount.setTableName(formKey);
        fieldAccount.setHtmlName("Custom_Verification_Style_1");
        fieldAccount.setFieldKey("field_account");
        fieldAccount.setRequired(true);
        fieldAccount.setEdit(true);
        res.add(fieldAccount);
        FormRuleDo fieldDesc = new FormRuleDo();
        fieldDesc.setTableName(formKey);
        fieldDesc.setHtmlName("Custom_Verification_Style_1");
        fieldDesc.setFieldKey("field_desc");
        fieldDesc.setRequired(true);
        fieldDesc.setEdit(true);
        res.add(fieldDesc);
        FormRuleDo fieldVolice = new FormRuleDo();
        fieldVolice.setTableName(formKey);
        fieldVolice.setHtmlName("Custom_Verification_Style_1");
        fieldVolice.setFieldKey("field_invoice");
        fieldVolice.setRequired(true);
        fieldVolice.setEdit(true);
        res.add(fieldVolice);
        return res;
    }

}
