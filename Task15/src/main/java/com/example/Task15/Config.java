package com.example.Task15;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class Config {
//
//    @Bean
//    public HikariDataSource dataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/camp");
//        config.setUsername("root");
//        config.setPassword("11");
//        return new HikariDataSource(config);
//    }
//
//    @Bean(name = "entityManagerFactory")
//    public LocalSessionFactoryBean factoryBean(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//
//        sessionFactoryBean.setPackagesToScan("com.example.Task15.model");
//        Properties properties = new Properties();
//        properties.setProperty("spring.jpa.show-sql", "true");
//        properties.setProperty("spring.jpa.generate-ddl", "true");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//        properties.setProperty("spring.jpa.hibernate.ddl-auto", "create");
//        sessionFactoryBean.setHibernateProperties(properties);
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager
//    platformTransactionManager(LocalSessionFactoryBean factoryBean) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(factoryBean.getObject());
//        return transactionManager;
//    }
}
