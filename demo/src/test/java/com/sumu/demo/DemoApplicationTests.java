package com.sumu.demo;

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

}
