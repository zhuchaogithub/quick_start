package com.example.common.config;

import com.example.common.config.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;

/**
 * @author  zxc
 * @date  2019/08/16
 */
@Configuration
public class MyBatisConfig {
    @Resource(name = "dynamicDataSource")
    private DynamicDataSource dynamicDataSource;

    /**
     * dynamicDataSource sqlSessionFactory
     *
     * @return
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:dao/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.web.entity");
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 注册 sqlSessionTemplate
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate financialMasterSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

