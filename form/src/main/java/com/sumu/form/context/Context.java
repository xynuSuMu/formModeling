package com.sumu.form.context;

import com.sumu.form.entity.AbstractManager;
import org.apache.ibatis.session.SqlSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-10 09:16
 */
public class Context {

    protected static Map<Class<?>, AbstractManager> managerMap = new ConcurrentHashMap<>();

    protected static SqlSession sqlSession;


    public static <T> T getManager(Class<T> clazz) {
        return (T) managerMap.get(clazz);
    }

    public static void setManager(Class<?> clazz, AbstractManager abstractManager) {
        managerMap.put(clazz, abstractManager);
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }

    public static void setSqlSession(SqlSession sqlSession) {
        Context.sqlSession = sqlSession;
    }
}
