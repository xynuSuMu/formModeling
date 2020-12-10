package com.sumu.form.mapper;

import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:29
 */
public interface FormInfoMapper {

    //获取所有表单
    List<TableInfoDo> getTableInfo();

    //获取表单样式分类
    List<BriefTableStyleDo> getBriefTableStyle(@Param("tableName") String tableName);

    //获取表单样式HTML
    String getTableStyleHtml(@Param("id") int id);
}
