package cn.ph.blog.core.configurer;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 在springboot中使用mybatis需要进行一些基本的配置，有两种方式，本项目采用的是使用配置类来配置
 * 另一种方式是在application.properties文件中配置
 */

@Configuration
public class MybatisConfigurer {

    /**
     * 作用相当于mybatis中的配置文件，也可以在application.properties中通过配置来代替此类
     * @param dataSource 从application.properties配置中取得数据源
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage("cn.ph.blog.mode");
        // 添加xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return factory.getObject();
    }

    /**
     * 设置SqlSessionFactory的名字与dao层的存储路径
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("cn.ph.blog.dao");
        return mapperScannerConfigurer;
    }
}
