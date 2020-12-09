package com.sumu.demo;

import com.sumu.form.bean.domin.FormRuleDo;
import com.sumu.form.bean.vo.ComponentView;
import com.sumu.form.bean.vo.FieldView;
import com.sumu.form.bean.vo.FormTableView;
import com.sumu.form.service.FormService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    FormService formService;

    @Test
    void deleteFormTable() {
        formService.deleteFormTable("form_custom_verification");
    }

    @Test
    void createFormTable() {
        formService.createFormTable(param());
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
        formService.saveFormTableStyle(tableName, formName, formDesc, sb.toString(), formRuleDos);

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
