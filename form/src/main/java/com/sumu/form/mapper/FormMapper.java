package com.sumu.form.mapper;


import com.sumu.form.bean.domin.*;
import com.sumu.form.bean.modal.ComponentModal;
import com.sumu.form.bean.modal.FieldModal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-11-27 15:29
 */
public interface FormMapper {

    //初始化
    int initTable();

    //是否存在表单
    String isExistForm(@Param("tableName") String tableName);

    //创建表单
    int createForm(@Param("tableName") String tableName,
                   @Param("cloums") List<FormDo> cloums,
                   @Param("tableComment") String tableComment);

    //删除表单
    int dropTable(@Param("tableName") String tableName);

    //表单信息
    int insertFormInfo(@Param("tableName") String tableName,
                       @Param("tableComment") String tableComment);

    //字段属性信息
    int insertAttribute(@Param("attributeDos") List<AttributeDo> attributeDos);

    //字段组件信息
    int insertComponent(@Param("componentDos") List<ComponentDo> componentDos);

    //获取表单字段信息
    List<FieldModal> getFormFieldInfo(@Param("tableName") String tableName);

    //获取组件信息
    List<ComponentModal> getFieldComponentInfo(@Param("tableName") String tableName,
                                               @Param("fieldKey") String fieldKey);

    //新建表单
    int insertFormTable(@Param("formName") String formName,
                        @Param("htmlDesc") String htmlDesc,
                        @Param("tableName") String tableName,
                        @Param("html") String html);

    //表单样式字段属性
    int insertFormTableStyle(@Param("formRuleDos") List<FormRuleDo> formRuleDos);


    //获取表单HTML
    String getForm(@Param("id") Integer id);

    //获取表单字段规则
    List<FormRuleDo> getFormRule(@Param("htmlName") String htmlName);

    //插入数据
    int insertForm(@Param("formKey") String formKey, @Param("columnMap") Map<String, Object> columnMap);

    //返回数据
    Map<String, Object> getFieldValue(@Param("tableName") String tableName, @Param("sysField") String sysField);



}
