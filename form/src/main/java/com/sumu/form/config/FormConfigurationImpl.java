package com.sumu.form.config;


import com.sumu.form.entity.data.DataManager;
import com.sumu.form.mapper.FormMapper;
import com.sumu.form.util.Util;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-09 15:14
 */
public class FormConfigurationImpl extends FormConfiguration {

    protected ApplicationContext applicationContext;

    protected DataSource dataSource;

    protected SqlSessionFactory sqlSessionFactory;

    protected SqlSession sqlSession;

    public FormConfigurationImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void builder() {
        initDB();
        initSqlSessionFactory();
        initDataManager();
    }

    private void initDB() {
        if (dataSource instanceof HikariDataSource) {
            this.jdbcDriver = ((HikariDataSource) dataSource).getDriverClassName();
            this.jdbcUsername = ((HikariDataSource) dataSource).getUsername();
            this.jdbcUrl = ((HikariDataSource) dataSource).getJdbcUrl();
            this.jdbcPassword = ((HikariDataSource) dataSource).getPassword();
        }
    }

    private void initSqlSessionFactory() {
        InputStream inputStream = null;
        try {
            inputStream = Util.getInputStream();
            Reader reader = new InputStreamReader(inputStream);
            Environment environment = new Environment("default", new JdbcTransactionFactory(), this.dataSource);
            Properties properties = new Properties();
            Configuration configuration = initMybatisConfiguration(environment, reader, properties);
            this.sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
            this.sqlSession = sqlSessionFactory.openSession();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public Configuration initMybatisConfiguration(Environment environment, Reader reader, Properties properties) {
        XMLConfigBuilder parser = new XMLConfigBuilder(reader, "", properties);
        Configuration configuration = parser.getConfiguration();

        configuration.setEnvironment(environment);
        configuration = parser.parse();
        return configuration;
    }

    protected void initDataManager() {
        DataManager.setFormMapper(this.sqlSession.getMapper(FormMapper.class), this.sqlSession);
    }
}
