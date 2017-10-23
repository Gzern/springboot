package com.example.demo.Bean;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * SpringBoot创建C3P0连接池
 */

@Configuration
//读取配置文件
@PropertySource("classpath:conf/jdbc.properties")
public class DataSourceConfiguration {

    @Bean("dataSource")
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }


    /**
     * mybaits使用数据源
     * 手动创建sqlsessionFactory对象会导致springboot的mybatis配置文件失效
     *
     * @return
     */
    @Bean("sqlSessionFactory")  //java代码生成Bean对象
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(getDataSource());
        //创建路径资源获取器
        PathMatchingResourcePatternResolver resolver=
                new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean;
    }
}
