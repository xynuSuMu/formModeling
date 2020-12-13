package com.sumu.form.entity.data;

import com.sumu.form.bean.domin.info.BriefTableStyleDo;
import com.sumu.form.bean.domin.info.TableInfoDo;
import com.sumu.form.config.FormConfigurationImpl;
import com.sumu.form.context.Context;
import com.sumu.form.mapper.FormInfoMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 15:33
 */
public class FormInfoDataManager extends AbstractDataManager {

    public FormInfoDataManager(FormConfigurationImpl formConfiguration
    ) {
        super(formConfiguration);
    }

    public List<TableInfoDo> getTableInfo() {
        SqlSession sqlSession = getSqlSession();
        try {
            return sqlSession.getMapper(FormInfoMapper.class).getTableInfo();
        } finally {
            sqlSession.close();
        }
    }


    public List<BriefTableStyleDo> getBriefTableStyle(String tableName) {
        SqlSession sqlSession = getSqlSession();
        try {
            return sqlSession.getMapper(FormInfoMapper.class).getBriefTableStyle(tableName);
        } finally {
            sqlSession.close();
        }
    }

    public String getTableStyleHtml(int id) {
        SqlSession sqlSession = getSqlSession();
        try {
            return sqlSession.getMapper(FormInfoMapper.class).getTableStyleHtml(id);
        } finally {
            sqlSession.close();
        }
    }


}
