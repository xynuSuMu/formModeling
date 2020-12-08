package com.sumu.form.api.config;

import com.sumu.form.FormManager;
import com.sumu.form.mapper.FormMapper;
import com.sumu.form.service.FormService;
import com.sumu.form.service.impl.FormServiceImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-08 16:38
 */
@Configuration
public class FormApiConfiguration {

    @Bean
    public FormMapper formMapper(DataSource dataSource) throws Exception {
        System.out.println(dataSource.getConnection().getAutoCommit() + "---");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development", transactionFactory, dataSource);


        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration(environment);
        configuration.setLazyLoadingEnabled(true);
        configuration.addMapper(FormMapper.class);


        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setConfiguration(configuration);
//        List<Resource> resources = new ArrayList();
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

        Resource[] mappers = resourceResolver.getResources("classpath*:com/sumu/form/db/xml/*.xml");

        sqlSessionFactoryBean.setMapperLocations(mappers);
        sqlSessionFactoryBean.setDataSource(dataSource);

        System.out.println("加载FormService");

//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBean.getObject();// builder.build(configuration);

        SqlSession sqlSession = new SqlSessionTemplate(factory);


        FormMapper o = sqlSession.getMapper(FormMapper.class);
        o.dropTable("form_custom_verification");
        return o;
    }

}
