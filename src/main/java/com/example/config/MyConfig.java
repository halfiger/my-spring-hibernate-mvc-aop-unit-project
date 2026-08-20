package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.example")
@PropertySource("classpath:database.properties")
public class MyConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String ddlAuto;


    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean =
                new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());

        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", ddlAuto);

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setPackagesToScan("com.example.entity");

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
